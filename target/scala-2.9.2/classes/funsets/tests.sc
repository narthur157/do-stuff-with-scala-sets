package funsets
import common._

object tests {
  println("what the fuck")                        //> what the fuck
  type Set = Int => Boolean
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
  
  //contains(("jack"), 0)
}