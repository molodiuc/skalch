package sketch.ui.sourcecode;

import sketch.dyn.main.old.ScOldDynamicSketch;

/**
 * Oracle which (if it had been a hole) would be rewritten as (arg)(!!-value)
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
public class ScSourceApplyOracle extends ScSourceUntilvOracle {
    public ScSourceApplyOracle(int uid, ScOldDynamicSketch sketch) {
        super(uid, sketch);
    }

    @Override
    public String getName() {
        return "ApplyOracle[uid=" + uid + "]";
    }
}
