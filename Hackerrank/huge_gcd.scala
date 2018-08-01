import scala.math.BigInt
object Solution {
    def gcd(x: BigInt, y: BigInt): BigInt = if(y==0) x else gcd(y,x%y)
    def hugeGCD(a: List[BigInt], b: List[BigInt]) = {
        gcd(a.reduceLeft(_ * _), b.reduceLeft(_ * _))
    }
    def main(args: Array[String]) {
        readInt
        val a = readLine.split(" ").map(BigInt(_)).toList
        readInt
        val b = readLine.split(" ").map(BigInt(_)).toList
        println(hugeGCD(a, b)%1000000007)
    }
}