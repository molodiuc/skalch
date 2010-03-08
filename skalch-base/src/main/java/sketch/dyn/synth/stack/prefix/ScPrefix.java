package sketch.dyn.synth.stack.prefix;

/**
 * represents the beginning of a stack. currently for synthesis only, but those specifics
 * should be kept to a minimum.
 * 
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you make
 *          changes, please consider contributing back!
 */
public abstract class ScPrefix {
    /**
     * Since a prefix doesn't know about untilv, it might go over it. If this happens, the
     * caller should call setAllSearched().
     */
    public abstract int nextValue();

    /** have all of the direct descendants of this subtree been searched? */
    public abstract boolean getAllSearched();

    public abstract void setAllSearched();

    /**
     * get the parent prefix to continue the search.
     * 
     * @param stack
     *            The current search stack. Set null if there is none.
     */
    public abstract ScPrefix getParent(ScPrefixSearch search);

    /**
     * most prefix searches are implicit through operations re-done on a local stack
     * instance, but this is useful to allow new or done threads to help.
     */
    public ScPrefixSearch explicitPrefix = null;

    public abstract ScPrefix addEntries(int addedEntries);
}
