object Solution {
    def swap(s: String): String = {
        s.toList.grouped(2).map(_.reverse).flatten.mkString
    }
    def main(args: Array[String]) {
        for(i<- 1 to readInt) println(swap(readLine))  
    }
}