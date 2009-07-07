package sketch.dyn.debug;

import java.util.Vector;

import sketch.dyn.ScDynamicSketch;
import sketch.dyn.inputs.ScFixedInputConf;
import sketch.dyn.synth.ScDynamicUntilvException;
import sketch.dyn.synth.ScStack;
import sketch.dyn.synth.ScSynthesisAssertFailure;

/**
 * static functions b/c I can't put them in ScUserInterface (java annoyance)
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
public class ScDebugSketchRun {
    protected ScDynamicSketch sketch;
    protected ScStack stack;
    protected ScFixedInputConf[] all_counterexamples;
    public boolean succeeded;
    public StackTraceElement assert_info;
    public Vector<ScDebugEntry> debug_out;

    public ScDebugSketchRun(ScDynamicSketch sketch, ScStack stack,
            ScFixedInputConf[] all_counterexamples)
    {
        this.sketch = sketch;
        this.stack = stack;
        this.all_counterexamples = all_counterexamples;
    }

    public void run() {
        sketch.solution_cost = 0;
        sketch.enable_debug();
        stack.set_for_synthesis(sketch);
        assert_info = null;
        succeeded = false;
        trycatch: try {
            stack.reset_before_run();
            for (ScFixedInputConf counterexample : all_counterexamples) {
                counterexample.set_input_for_sketch(sketch);
                if (!sketch.dysketch_main()) {
                    break trycatch;
                }
            }
            succeeded = true;
        } catch (ScSynthesisAssertFailure e) {
            assert_info = sketch.debug_assert_failure_location;
        } catch (ScDynamicUntilvException e) {
            assert_info = sketch.debug_assert_failure_location;
        }
        debug_out = sketch.debug_out;
        sketch.debug_out = null;
    }

    public boolean assert_failed() {
        return assert_info == null;
    }
}
