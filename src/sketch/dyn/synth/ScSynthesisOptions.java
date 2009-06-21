package sketch.dyn.synth;

import sketch.util.CliOptGroup;

/**
 * command line options for synthesis.
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
public class ScSynthesisOptions extends CliOptGroup {
    public ScSynthesisOptions() {
        prefixes("sy", "synth", "synthesis");
        add("--num_solutions", 1, "number of solutions to find");
        add("--num_threads", Runtime.getRuntime().availableProcessors(),
                "override number of threads (default # of processors)");
        add("--print_exceptions", "print all exceptions raised by the sketch");
        add("--print_counterexamples",
                "print values generated by counterexamples");
        add("--debug_stop_after", -1, "stop after a number of runs");
    }
}
