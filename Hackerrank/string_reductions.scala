object Solution {

    def stringReductions(i: String) = i.split("").toList.distinct.mkString
    
    def main(args: Array[String]) {
        println(stringReductions(readLine))
    }
}