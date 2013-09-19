import math.abs
object lectureNotes {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
 //@tailrec
 
 def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(12); val res$0 = 
 gcd(14,21);System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
 gcd(3,9);System.out.println("""res1: Int = """ + $show(res$1));$skip(147); 
 //@tailrec
 def factorialA(n: Int): Int = {
   def loop(acc:Int, n:Int): Int =
     if (n == 0) acc
     else loop(acc * n, n-1)
   loop(1, n)
 };System.out.println("""factorialA: (n: Int)Int""");$skip(15); val res$2 = 
 factorialA(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(164); 
 
 def sum(f: Int => Int, a: Int, b: Int): Int = {
   def loop(a: Int, acc: Int): Int = {
     if (a > b) acc
     else loop(a+1, f(a) + acc)
   }
   loop(a, 0)
 };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(168); 
 def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
   if (a>b) zero
   else combine(f(a), mapReduce(f, combine, zero)(a+1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(88); 
 def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a,b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(20); val res$3 = 
 product(x=>x)(1,3);System.out.println("""res3: Int = """ + $show(res$3));$skip(24); 
 val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(75); 
 def isCloseEnough(x: Double, y: Double) =
   abs((x - y) / x) < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(219); 
 def fixedPoint(f: Double => Double)(firstGuess: Double) = {
   def iterate(guess: Double): Double = {
   val next = f(guess)
   if (isCloseEnough(guess, next)) next
   else iterate(next)
   }
   iterate(firstGuess)
 };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(27); val res$4 = 
 fixedPoint(x => 1+x/2)(1);System.out.println("""res4: Double = """ + $show(res$4));$skip(64); 
 def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0);System.out.println("""sqrt: (x: Double)Double""");$skip(66); 
 def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""")}
 
 
}