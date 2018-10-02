import scala.language.implicitConversions


class Rational private(val n: Double, val d: Double){
    require(d!=0, "lol")
    override def toString: String = s"R($n/$d)" 
    def min(other: Rational): Rational = {
        if(n/d < other.n/other.d) this else other
    }
    def +(other: Rational): Rational = {
        new Rational(this.n * other.d + this.d * other.n, this.d * other.d)
    }
    //def +(i: Double): Rational = this +  Rational(i)
}

object Rational{
    def apply(n: Double, d: Double) : Rational = new Rational(n, d)
    implicit def apply(n: Double) : Rational = new Rational(n, 1)
}


val r1 = Rational(1, 2)
val r2 = Rational(3, 4)
val five = Rational(5)
r1 min r2
r1 + r2
r1 + five
Rational(3, 4) + 5

24 + five