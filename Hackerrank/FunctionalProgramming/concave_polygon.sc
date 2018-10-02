import scala.collection.mutable.ArrayBuffer
object Solution {
  type Coordinate = (Int, Int)
  def array2Tuple(a: Array[Int]): Coordinate = (a(0), a(1))
  def isConcave(polygon: List[Coordinate]): String = {
    if (polygon.length < 3) return "NO"
    var zcrossproducts = Array.empty[Int]
    for(triplet <- polygon.sliding(3).toList){
      val dx1 = triplet(1)._1 - triplet(0)._1
      val dx2 = triplet(2)._1 - triplet(1)._1
      val dy1 = triplet(1)._2 - triplet(0)._2
      val dy2 = triplet(2)._2 - triplet(1)._2
      val z = dx1 * dy2 - dy1 * dx2
      zcrossproducts :+ z
    }
    if((zcrossproducts.filter(_ > 0).length == zcrossproducts.length) ||
      (zcrossproducts.filter(_ < 0).length == zcrossproducts.length)) "NO"
    else "YES"

  }

  def main(args: Array[String]) {
    val points = (1 to readInt).map(_ => array2Tuple(readLine.split(' ').map(_.toInt))).toList
    println(isConcave(points))
  }
}