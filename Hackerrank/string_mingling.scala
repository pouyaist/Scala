object Solution {

    def main(args: Array[String]) =
        println((readLine zip readLine).flatMap(t => List(t._1, t._2)).mkString(""))
}