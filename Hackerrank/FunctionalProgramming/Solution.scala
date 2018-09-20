import scala.collection.mutable.ListBuffer
object Solution {
    case class Point(x: Double, y: Double)

    /** Compute the convex hull of given points. Returns vertices ordered ccw */
    def convexHull(_points: Seq[Point]): Seq[Point] = {
      val points = _points.sortBy(_.x)
      val upper = halfHull(points)
      val lower = halfHull(points.reverse)
      upper.remove(0)
      lower.remove(0)
      upper ++: lower
    }

    def halfHull(points: Seq[Point]) = {
      val upper = new ListBuffer[Point]()
      for (p <- points) {
        while (upper.size >= 2 && leftTurn(p, upper(0), upper(1))) {
          upper.remove(0)
        }
        upper.prepend(p)
      }
      upper
    }

    def leftTurn(p1: Point, p2: Point, p3: Point) = {
      val slope = (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x)
      val collinear = math.abs(slope) <= 1e-9
      val leftTurn = slope < 0
      collinear || leftTurn
    }
    
    def main(args: Array[String]) {
        var points = Seq.empty
        for(t<-1 to readInt) {
            val point = readLine.split(" ").map(_.toInt)
            
        }
    }
}