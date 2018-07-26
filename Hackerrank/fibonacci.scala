import scala.math.BigInt
object Solution {
    lazy val fibs: Stream[BigInt] = BigInt(0) #::
                                    BigInt(1) #::
                                    fibs.zip(fibs.tail).map { n => n._1 + n._2 }
    def main(args: Array[String]) {
        val r = scala.math.pow(10,8) + 7
        for(i<-1 to readInt)
        {
            println(fibs(readInt) % r.toInt)
        }
    }
}