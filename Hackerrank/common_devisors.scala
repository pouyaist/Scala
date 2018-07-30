object Solution {
    def divisors(n: Int) = n match{
        case 1 => List(1)
        case _ => (1 to n/2).filter(i => n % i == 0) ++ Vector(n)
    }
    def gcd(x: Int, y: Int): Int = if(y==0) x else gcd(y,x%y)
    def main(args: Array[String]) {
        for(i<-1 to readInt)
        {
            val ml = readLine.split(" ").map(_.toInt)
            println(divisors(gcd(ml(0), ml(1))).length)          
        }
    }
}