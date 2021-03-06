package sketch.compiler.parser.gxlimport;

import net.sourceforge.gxl.GXLNode;

/**
 * mostly generated by Eclipse
 *
 * @author gatoatigrado
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you make
 *          changes, please consider contributing back!
 */
public class NodeStringTuple {
    public final GXLNode node;
    public final String str;
    public final int hash;

    public NodeStringTuple(final GXLNode node, final String edgename) {
        this.node = node;
        this.str = edgename;
        this.hash = (node.getID() + " edge " + edgename).hashCode() * 1097933;
    }

    @Override
    public int hashCode() {
        return this.hash;
    }

    @Override
    public boolean equals(final Object obj) {
        return this.hash == obj.hashCode();
    }
}
