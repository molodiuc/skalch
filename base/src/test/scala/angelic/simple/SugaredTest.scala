package angelic.simple
import skalch.{AngelicSketch, SkalchIgnoreClass}
import sketch.util._

class MySketch() extends AngelicSketch {
    def main() {
        val a = new Array[Int](5)
        assert(a(0) == 0)
        tprint("array element zero" -> a(0),
            "array element zero is zero" -> (a(0) == 0))
    }
}
