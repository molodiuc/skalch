package sketch.dyn.ga;

import java.util.Vector;

import sketch.dyn.ScClonedConstructInfo;
import sketch.dyn.ScDynamicSketch;
import sketch.dyn.ctrls.ScGaCtrlConf;
import sketch.dyn.ga.base.ScGaIndividual;
import sketch.dyn.inputs.ScFixedInputConf;
import sketch.dyn.inputs.ScGaInputConf;
import sketch.dyn.synth.ScDynamicUntilvException;
import sketch.dyn.synth.ScLocalSynthesis;
import sketch.dyn.synth.ScSynthesisAssertFailure;
import sketch.ui.modifiers.ScUiModifier;
import sketch.util.DebugOut;

/**
 * Container for a GA synthesis thread. The actual thread is an inner class
 * because the threads will die between synthesis rounds, whereas the sketch
 * object doesn't need to be deleted.
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
public class ScLocalGaSynthesis extends ScLocalSynthesis {
    protected ScGaSynthesis gasynth;

    public ScLocalGaSynthesis(ScDynamicSketch sketch, ScGaSynthesis gasynth,
            int uid)
    {
        super(sketch, uid);
        this.gasynth = gasynth;
    }

    @Override
    protected AbstractSynthesisThread create_synth_thread() {
        DebugOut.assertSlow(gasynth.wait_handler != null, "wait_null");
        return new SynthesisThread();
    }

    public class SynthesisThread extends AbstractSynthesisThread {
        protected boolean exhausted;
        protected ScGaIndividual current_individual;
        protected ScGaCtrlConf ctrl_conf;
        protected ScGaInputConf oracle_conf;
        protected Vector<ScPopulation> local_populations;

        /** evaluate $this.current_individual$ */
        protected void evaluate() {
            current_individual.set_for_synthesis_and_reset(sketch, ctrl_conf,
                    oracle_conf);
            sketch.solution_cost = 0;
            nruns++;
            trycatch: try {
                for (ScFixedInputConf counterexample : counterexamples) {
                    ncounterexamples++;
                    counterexample.set_input_for_sketch(sketch);
                    if (!sketch.dysketch_main()) {
                        break trycatch;
                    }
                }
                gasynth.add_solution(current_individual);
            } catch (ScSynthesisAssertFailure e) {
            } catch (ScDynamicUntilvException e) {
                DebugOut.assertFalse("ga shouldn't get any "
                        + "dynamic untilv exceptions.");
            }
        }

        /** evaluate all pending individuals from all local populations */
        private void blind_fast_routine() {
            // print_colored(BASH_DEFAULT, "[ga-synth]", " ", false,
            // "=== generation eval ===");
            for (ScPopulation population : local_populations) {
                while (population.test_queue_nonempty()) {
                    current_individual =
                            population.get_individual_for_testing();
                    evaluate();
                    population.add_done(current_individual
                            .set_done(sketch.solution_cost));
                }
            }
        }

        /** generate new individuals and kill off unfit or old ones */
        protected void iterate_populations() {
            // print_colored(BASH_DEFAULT, "[ga-synth]", " ", false,
            // "=== generation iterate ===");
            for (ScPopulation population : local_populations) {
                population.generate_new_phase();
                population.death_phase();
            }
        }

        @Override
        protected void run_inner() {
            ScClonedConstructInfo[] info =
                    ScClonedConstructInfo.clone_array(sketch.get_hole_info());
            ScClonedConstructInfo[] oracle_info =
                    ScClonedConstructInfo.clone_array(sketch.get_oracle_info());
            local_populations = new Vector<ScPopulation>();
            local_populations.add(new ScPopulation(gasynth.spine_length));
            ctrl_conf = new ScGaCtrlConf(info);
            oracle_conf = new ScGaInputConf(oracle_info);
            for (long a = 0; !gasynth.wait_handler.synthesis_complete.get(); a +=
                    nruns)
            {
                // print_colored(BASH_DEFAULT, "\n\n\n[ga-synth]", " ", false,
                // "=== generation start ===");
                update_stats();
                if (a >= gasynth.debug_stop_after) {
                    DebugOut.print("wait exhausted...", a,
                            gasynth.debug_stop_after);
                    gasynth.wait_handler.wait_exhausted();
                }
                //
                // NOTE to readers: main call
                blind_fast_routine();
                if (!ui_queue.isEmpty()) {
                    process_ui_queue(ui_queue.remove());
                }
                iterate_populations();
            }
        }

        @Override
        protected void process_ui_queue(ScUiModifier ui_modifier) {
            ui_modifier.setInfo(ScLocalGaSynthesis.this, this,
                    current_individual);
        }
    }
}
