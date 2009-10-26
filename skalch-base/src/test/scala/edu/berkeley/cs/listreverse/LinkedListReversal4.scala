package edu.berkeley.cs.listreverse

import skalch.AngelicSketch
import sketch.dyn.BackendOptions
import sketch.util._

// fail, only works at appending to end, need external list
class LinkedListReversalSketch4 extends AngelicSketch {
	val tests = Array( () )
	
	def main() {
		def reverse[T](list : List[T]) : List[T] = {
			var revList : List[T] = Nil
			val up : Boolean = !!()
			
			def reverseRec(list : List[T]) : Unit = {
				var value : T = list.head
				
				if (up && !!())
					revList = value :: revList
				
				if (!!() && !list.tail.isEmpty) {
					reverseRec(list.tail)
					skdprint(revList.toString())
				}
				
				if (!up && !!())
					revList = value :: revList
					
			}
			reverseRec(list)
			return revList;
		}
		
		val l : List[String] = List("1", "2", "3", "4")
		val rev : List[String] = List("4", "3", "2", "1")
		val rev_l = reverse(l)
		synthAssertTerminal(rev_l == rev)
	}
}

object ListReverseMain4 {
	def main(args: Array[String]) = {
		for (arg <- args)
			Console.println(arg)
	    val cmdopts = new cli.CliParser(args)
	    BackendOptions.add_opts(cmdopts)
		skalch.AngelicSketchSynthesize(() => 
			new LinkedListReversalSketch4())
	}
}