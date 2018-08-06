object Solution {
    def superDigit(n : String, k : Long): Long = n.length match {
      case 1 if k==1 => n.toLong
      case _ => superDigit((n.chars().filter(_ != 48).map(_-48).asLongStream().sum()*k).toString, 1)
    }
    def main(args: Array[String]) {
        var number = readLine.split(" ").toList
        println(superDigit(number(0), number(1).toLong))
    }
}