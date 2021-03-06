package sketch.dyn.constructs.inputs;

import static sketch.util.fcns.ScArrayUtil.extend_arr;

import java.util.Vector;

import sketch.dyn.synth.ga.base.ScGaIndividual;
import sketch.dyn.synth.ga.base.ScPhenotypeEntry;
import sketch.ui.sourcecode.ScConstructValue;
import sketch.ui.sourcecode.ScConstructValueString;
import sketch.ui.sourcecode.ScNoValueStringException;
import sketch.util.ScCloneable;

/**
 * proxy class which will call into a ScGaIndividual
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
public class ScGaInputConf extends ScInputConf implements
        ScCloneable<ScGaInputConf>
{
    public ScGaIndividual base;
    public int[] next = new int[0];
    public int[] default_untilv = new int[0];

    public ScGaInputConf() {
    }

    protected ScGaInputConf(int[] next, int[] default_untilv) {
        this.next = next;
        this.default_untilv = default_untilv;
    }

    @Override
    public int dynamicNextValue(int uid, int untilv) {
        if (uid >= next.length) {
            realloc(2 * uid + 1);
        }
        int rv = base.synthGetValue(false, uid, next[uid], untilv);
        next[uid] += 1;
        return rv;
    }

    @Override
    public Vector<ScConstructValueString> getValueString(int uid)
            throws ScNoValueStringException
    {
        Vector<ScConstructValueString> result =
                new Vector<ScConstructValueString>();
        if (uid >= next.length) {
            return result;
        }
        for (int subuid = 0; subuid < next[uid]; subuid++) {
            ScConstructValue value =
                    new ScConstructValue(base.displayGetValue(false, uid,
                            subuid, 1 << 20));
            result.add(new ScConstructValueString("", value, ""));
        }
        return result;
    }

    @Override
    public int nextValue(int uid) {
        int rv = base.synthGetValue(false, uid, next[uid], default_untilv[uid]);
        next[uid] += 1;
        return rv;
    }

    protected void realloc(int length) {
        next = extend_arr(next, length);
        default_untilv = extend_arr(next, length, 10);
    }

    @Override
    public ScGaInputConf clone() {
        return new ScGaInputConf(next.clone(), default_untilv.clone());
    }

    public void reset_accessed() {
        for (int a = 0; a < next.length; a++) {
            next[a] = 0;
        }
    }

    @Override
    public int[] getValueArray() {
        Vector<ScPhenotypeEntry> activeCtrls =
                base.phenotype.getActiveEntriesOfType(false);
        int[] result = new int[activeCtrls.size()];
        for (int a = 0; a < activeCtrls.size(); a++) {
            result[a] =
                    base.genotype.getValue(activeCtrls.get(a).index, 1 << 50);
        }
        return result;
    }
}
