package funsets
import common._


/**
 * 2. Purely Functional Sets.
 */
object aTwo {
  /*
    We represent a set by its characteristic function, i.e.
    its `contains` predicate
   */
   println("really?")                             //> really?
  type Set = Int => Boolean
  // this works val foo = Set((x:Int)=>x>0)
  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean
  contains((x:Int)=>x>0, 3)                       //> res0: Boolean = true
  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = Set(elem)    //> singletonSet: (elem: Int)Int => Boolean
  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  // pretend s => s > 0
  // pretend t => t > 1
  // union x => (x > 0) || (t > 1)
  // intersection x => (x>0) && (t > 1)
  // difference x => if !(t>1)(x>0)
  def union(s: Set, t: Set): Set = (x:Int)=> contains(s, x) || contains(t, x)
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  
  //contains(union( (x:Int)=> x < 10, (x:Int)=>x>12 ), 11)
 
  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` or `t`.
   */
  def intersect(s: Set, t: Set): Set = (x:Int)=> contains(s, x) && contains(t,x)
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
	//contains(intersect( (x:Int)=> x < 15, (x:Int)=>x>12 ), 13)
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = (x:Int)=> !contains(t,x) && contains(s,x)
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
  //contains(diff( (x:Int)=> x >5 , (x:Int)=>x>12 ), 13)
  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = (x:Int)=> contains(s,x) && contains(p,x)
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean
  contains(filter( (x:Int)=> x >5 , (x:Int)=>x>12 ), 13)
                                                  //> res1: Boolean = true
  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000                                //> bound  : Int = 1000

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
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = true
                                                  //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean
    //if !(forall(s, p) filter(s, (x:Int)

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = singletonSet(1)
                                                  //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: Int => Boolean)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: Int => Boolean)Unit
}