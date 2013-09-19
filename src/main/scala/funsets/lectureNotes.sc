import math.abs
object lectureNotes {
 //@tailrec
 
 def gcd(a:Int, b:Int):Int = if (b == 0) a else gcd(b, a % b)
                                                  //> gcd: (a: Int, b: Int)Int
 gcd(14,21)                                       //> res0: Int = 7
 gcd(3,9)                                         //> res1: Int = 3
 //@tailrec
 def factorialA(n: Int): Int = {
   def loop(acc:Int, n:Int): Int =
     if (n == 0) acc
     else loop(acc * n, n-1)
   loop(1, n)
 }                                                //> factorialA: (n: Int)Int
 factorialA(4)                                    //> res2: Int = 24
 
 def sum(f: Int => Int, a: Int, b: Int): Int = {
   def loop(a: Int, acc: Int): Int = {
     if (a > b) acc
     else loop(a+1, f(a) + acc)
   }
   loop(a, 0)
 }                                                //> sum: (f: Int => Int, a: Int, b: Int)Int
 def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
   if (a>b) zero
   else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
 def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a,b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
 product(x=>x)(1,3)                               //> res3: Int = 6
 val tolerance = 0.0001                           //> tolerance  : Double = 1.0E-4
 def isCloseEnough(x: Double, y: Double) =
   abs((x - y) / x) < tolerance                   //> isCloseEnough: (x: Double, y: Double)Boolean
 def fixedPoint(f: Double => Double)(firstGuess: Double) = {
   def iterate(guess: Double): Double = {
   val next = f(guess)
   if (isCloseEnough(guess, next)) next
   else iterate(next)
   }
   iterate(firstGuess)
 }                                                //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
 fixedPoint(x => 1+x/2)(1)                        //> res4: Double = 1.9998779296875
 def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0)
                                                  //> sqrt: (x: Double)Double
 def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
 
 
}