object Solution {

    def area(coords: List[(Int, Int)]): Double = {
        var area: Double = 0
        for(i<-0 until coords.length)
        {
            val j = (i + 1) % coords.length
            area += coords(i)._1 * coords(j)._2
            area -= coords(j)._1 * coords(i)._2
        }
       Math.abs(area) / 2.0
    }
    def main(args: Array[String]) {
        /*A = abs (0.5 * sum(x(i)*y(i+1) - x(i+1)*y(i), i, 0, n-1))*/
        val n = readInt

       val coords = (0 until n).map { _ =>
          val p = readLine.split(" ").map(_.toInt)
          p(0) -> p(1)
        }.toList
        
        println(area(coords))

        
    }
}