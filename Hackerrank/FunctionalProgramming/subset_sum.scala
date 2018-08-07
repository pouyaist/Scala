object Solution {

    def subsetSum(ls: List[Int], p: Int): Int = {
        var sum = 0
        for (i<-0  until ls.length)
        {
            if(sum >= p) return i
            else sum += ls(i) 
        }
        -1
    }
    def main(args: Array[String]) {
        readInt
        var ls = readLine.split(" ").map(_.toInt).sorted.reverse.toList
        val n = readInt
        for(i<-0 until n) { 
          var p = readInt
          println(subsetSum(ls, p))
        }
    }
}