import scala.collection.mutable.Stack
object Solution {

  def canRepresentBST(pre: List[Int]): String = {
    var s = Stack[Int]()
    var root = -1
    for (value <- pre)
    {
      if (value < root) return "NO"
      while(s.length > 0  && s.top < value)
        root = s.pop
      s.push(value)
    }
    "YES"
  }
  def main(args: Array[String]) {
    for(_<-1 to readInt)
    {
      readInt
      println(canRepresentBST(readLine.split(" ").map(_.toInt).toList))
    }
  }
}