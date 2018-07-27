object Solution {
  def factorial(n: Int) = List.range(1, n+1).foldLeft(1)(_*_)

  def pascalTriangle(n: Int) = {
    for(i<-0 until n)
    {
      for(j<-0 to i)
      {
        print((factorial(i)/(factorial(j) * factorial(i-j))) + " ")
      }

      println()
    }
  }

  def main(args: Array[String]) {
    pascalTriangle(readInt)
  }
}
