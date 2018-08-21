object Solution {
    def lcm(list: Seq[BigInt]):BigInt = list.foldLeft(1:BigInt){
      (a, b) => b * a /
      Stream.iterate((a,b)){case (x,y) => (y, x%y)}.dropWhile(_._2 != 0).head._1.abs
    }
    def main(args: Array[String]) {
        readInt
        println(lcm(readLine.split(" ").map(BigInt(_)).toSeq))
    }
}