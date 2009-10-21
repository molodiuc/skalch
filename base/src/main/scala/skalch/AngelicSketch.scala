package skalch

import sketch.util.DebugOut

/**
 * New dynamic sketching base class. Most everything interesting is done
 * through the plugin; the Scala code here is only to maintani syntax/type
 * compatibility.
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
abstract class AngelicSketch {
    abstract class _SketchConstruct
    object !! extends _SketchConstruct
    object ?? extends _SketchConstruct

    var stopOptimization : Boolean = false

    implicit def _resolve[T <: AnyRef](x : ??.type) : T =
        { assert(false); if (stopOptimization) null else "".asInstanceOf[T] }

    implicit def _resolve[T <: AnyRef](x : !!.type) : T =
        { assert(false); if (stopOptimization) null else "".asInstanceOf[T] }

    def synthAssert(v : Boolean) { scala.Predef.assert(false); }
    def skdprint(x : => String) { assert(false); }
    def skdprint_loc(x : => String) { assert(false); }

    class Range[T](values : Seq[T]) extends StaticAnnotation
}
