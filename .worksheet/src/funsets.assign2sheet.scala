package funsets
import common._


/**
 * 2. Purely Functional Sets.
 */
object assign2sheet {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = (Int => Boolean)import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(348); 

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(101); 
  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = elem;System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(159); 

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = ???;System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(167); 

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` or `t`.
   */
  def intersect(s: Set, t: Set): Set = ???;System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(159); 

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = ???;System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(116); 

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = ???;System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(88); 

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(254); 

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (???) ???
      else if (???) ???
      else iter(???)
    }
    iter(???)
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(156); 

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = ???;System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(128); 

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = ???;System.out.println("""map: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(185); 

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