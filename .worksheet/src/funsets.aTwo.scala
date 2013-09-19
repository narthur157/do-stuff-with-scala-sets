package funsets
import common._


/**
 * 2. Purely Functional Sets.
 */
object aTwo {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(207); 
  /*
    We represent a set by its characteristic function, i.e.
    its `contains` predicate
   */
   println("really?")
  type Set = Int => Boolean;$skip(192); 
  // this works val foo = Set((x:Int)=>x>0)
  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(28); val res$0 = 
  contains((x:Int)=>x>0, 3);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(106); 
  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = Set(elem);System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(356); 
  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  // pretend s => s > 0
  // pretend t => t > 1
  // union x => (x > 0) || (t > 1)
  // intersection x => (x>0) && (t > 1)
  // difference x => if !(t>1)(x>0)
  def union(s: Set, t: Set): Set = (x:Int)=> contains(s, x) || contains(t, x);System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(268); 
  
  //contains(union( (x:Int)=> x < 10, (x:Int)=>x>12 ), 11)
 
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` or `t`.
   */
  def intersect(s: Set, t: Set): Set = (x:Int)=> contains(s, x) && contains(t,x);System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(258); 
	//contains(intersect( (x:Int)=> x < 15, (x:Int)=>x>12 ), 13)
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = (x:Int)=> !contains(t,x) && contains(s,x);System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(209); 
  //contains(diff( (x:Int)=> x >5 , (x:Int)=>x>12 ), 13)
  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = (x:Int)=> contains(s,x) && contains(p,x);System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(57); val res$1 = 
  contains(filter( (x:Int)=> x >5 , (x:Int)=>x>12 ), 13);System.out.println("""res1: Boolean = """ + $show(res$1));$skip(87); 
  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(297); 

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a < -1000) true
      else if (contains( filter(s, p), a) == false) false
      else iter(a-1)
    }
    iter(bound)
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(157); 

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = true;System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(182); 
    //if !(forall(s, p) filter(s, (x:Int)

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = singletonSet(1);System.out.println("""map: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(185); 

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  };System.out.println("""toString: (s: Int => Boolean)String""");$skip(117); 

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  };System.out.println("""printSet: (s: Int => Boolean)Unit""")}
}