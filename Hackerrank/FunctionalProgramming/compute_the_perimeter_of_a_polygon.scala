object Solution {
    
    def distance(p1:(Int,Int),p2:(Int,Int)): Double =
      math.sqrt(math.pow(p1._1-p2._1,2)+math.pow(p1._2-p2._2,2))
    
    def perimeter(coords: List[(Int, Int)]): Double = {
        var sum: Double = 0.0
        for(i<-1 until coords.length)
        {
            sum += distance(coords(i-1), coords(i))
        }
        sum + distance(coords.head, coords.last)
    }
    
    
    def main(args: Array[String]) {
        /*A = abs (0.5 * sum(x(i)*y(i+1) - x(i+1)*y(i), i, 0, n-1))*/
        val n = readInt

       val coords = (0 until n).map { _ =>
          val p = readLine.split(" ").map(_.toInt)
          p(0) -> p(1)
        }.toList

        println(perimeter(coords))
    }

}