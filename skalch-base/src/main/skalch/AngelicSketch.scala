package skalch

import sketch.util.DebugOut

/**
 * New dynamic sketching base class. This class supports the oracle,
 * and relies on a "tests" variable to be set.
 * See examples in the "test" directory for usage.
 * @author gatoatigrado (nicholas tung) [email: ntung at ntung]
 * @license This file is licensed under BSD license, available at
 *          http://creativecommons.org/licenses/BSD/. While not required, if you
 *          make changes, please consider contributing back!
 */
abstract class AngelicSketch extends sketch.dyn.main.ScAngelicSketchBase {
    // NOTE - the "[[string]]" part of the annotations is what is currently recognized
    // from the compiler. This should be an associative recognition in the future.

    /** NOTE - description annotations are necessary to know how to complete the hole. */
    @DescriptionAnnotation("[[integer untilv hole]] basic hole")
    def ??(@CompilerUid uid: Int, untilv: Int): Int = ctrl_conf.getDynamicValue(uid, untilv)

    @DescriptionAnnotation("[[object apply hole]] sequence select hole")
    def ??[T](uid : Int, list: Seq[T]) : T =
        list(ctrl_conf.getDynamicValue(uid, list.length))

    @DescriptionAnnotation("[[object apply hole]] array select hole")
    def ??[T](uid : Int, arr: Array[T]) : T =
        arr(ctrl_conf.getDynamicValue(uid, arr.length))

    @DescriptionAnnotation("[[class assign hole]] instantiate a class with hole values")
    def ??(@CompilerUid uid : Int, @CompilerClassOfResult resultClass : Class[_]) {
        DebugOut.assertFalse("not implemented yet...")
    }

    @DescriptionAnnotation("[[boolean oracle]] boolean oracle")
    def !!(uid : Int) : Boolean = oracle_conf.dynamicNextValue(uid, 2) == 1

    @DescriptionAnnotation("[[integer untilv oracle]] basic oracle")
    def !!(uid: Int, untilv: Int): Int = oracle_conf.dynamicNextValue(uid, untilv)

    @DescriptionAnnotation("[[object apply oracle]] array select oracle")
    def !![T](uid : Int, arr: Array[T]) : T =
        arr(oracle_conf.dynamicNextValue(uid, arr.length))

    @DescriptionAnnotation("[[object apply oracle]] sequence select oracle")
    def !![T](uid : Int, list: Seq[T]) : T =
        list(oracle_conf.dynamicNextValue(uid, list.length))

    @DescriptionAnnotation("[[object apply oracle]] 2 value select oracle")
    def !![T](uid : Int, v1 : T, v2 : T) : T =
        oracle_conf.dynamicNextValue(uid, 2) match {
            case 0 => v1
            case 1 => v2
        }

    @DescriptionAnnotation("[[object apply oracle]] 3 value select oracle")
    def !![T](uid : Int, v1 : T, v2 : T, v3 : T) : T =
        oracle_conf.dynamicNextValue(uid, 3) match {
            case 0 => v1
            case 1 => v2
            case 2 => v3
        }

    @DescriptionAnnotation("[[integer untilv oracle]] basic oracle with debugging")
    def `!!d`(uid: Int, untilv: Int): Int = {
        import java.lang.Integer
        assert(untilv > 0, "sketch provided bad untilv, not greater than zero. untilv=" + untilv)
        val rv = oracle_conf.dynamicNextValue(uid, untilv)
        skCompilerAssert(rv >= 0 && rv < untilv, "compiler returned bad result",
            "result", rv : Integer, "untilv", untilv : Integer)
        rv
    }

    @DescriptionAnnotation("[[object apply oracle]] array select oracle with debugging")
    def `!!d`[T](uid : Int, arr: Array[T]) : T = {
        import java.lang.Integer
        val untilv = arr.length
        assert(untilv > 0, "sketch provided bad untilv, not greater than zero. untilv=" + untilv)
        val rv = oracle_conf.dynamicNextValue(uid, untilv)
        skCompilerAssert(rv >= 0 && rv < untilv, "compiler returned bad result",
            "result", rv : Integer, "untilv", untilv : Integer)
        arr(rv)
    }



    // === methods defined by a subclass ===
    /** e.g. def main(x : Int, y : Int) = { synthAssertTerminal(??() == 3) } */
    val main : AnyRef

    /** e.g. Array( (1, 2), (3, 4) ) */
    val tests : Array[_]



    // === Utility functions ===
    // Most of these should be in ScDynamicSketch if possible, but some
    // constructs like "def" params are only available for Scala.
    def skdprint(x : => String) {
        if (debug_print_enable) {
            skdprint_backend(x)
        }
    }

    def skdprint_loc(x : => String) {
        if (debug_print_enable) {
            skdprint_location_backend(x)
        }
    }
}

object AngelicSketchSynthesize {
    def apply(f : (() => AngelicSketch)) {
        val synth = new sketch.dyn.main.ScAngelicSynthesisMain(f)
        synth.synthesize()
    }
}
