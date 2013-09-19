package funsets
import common._

object tests {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(74); 
  println("what the fuck")
  type Set = Int => Boolean;$skip(81); 
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""")}
  
  //contains(("jack"), 0)
}