
object Solution {
  def rotate(s: String, n: Int): String = s.drop(n) ++ s.take(n)
  def printRotates(s: String) = for(i <- 1 to s.length) print(rotate(s, i) + " ")
  def main(args: Array[String]) {
    for(i <- 1 to readInt)
    {
      printRotates(readLine)
      println()
    }
  }
}