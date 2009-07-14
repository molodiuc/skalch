package test.df

import sketch.dyn.BackendOptions
import sketch.util._
import DebugOut.print

class DfRestrictedSketch() extends AbstractDfSketch() {
    class Register(var value : Int)
    val registers = (for (i <- 0 until 10) yield new Register(-1)).toArray
    var num_registers = -1

    override def df_init() {
        num_registers = !!(2) + 3
        skAddCost(num_registers)
    }

    def reset_registers() {
        var i = 0
        while (i < num_registers) {
            registers(i).value = 0
            i += 1
        }
    }

    def df_main() {
        skdprint_loc("df_main()")
        reset_registers()
        var i = 0
        while (i < num_buckets) {
            var color = buckets(i).order
            if (registers(color).value != i) {
                swap(registers(color).value, i)
            }

            if (!!()) {
                // NOTE - this is too restrictive...
                // swap(registers(color).value, registers(!!(num_registers)).value)
                // while this works
                swap(registers(!!(num_registers)).value, registers(!!(num_registers)).value)
                skAddCost(1)
            }

            // I want the registers to be indices in which to insert the next element of a particular color
            while (color < 3) {
                registers(color).value += 1
                color += 1
            }

            skdprint(abbrev_str())
            i += 1
        }
    }
}

object DfRestrictedTest {
    def main(args : Array[String]) = {
        val cmdopts = new cli.CliParser(args)
        AbstractDfOptions.result = AbstractDfOptions.parse(cmdopts)
        BackendOptions.add_opts(cmdopts)
        skalch.synthesize(() => new DfRestrictedSketch())
    }
}