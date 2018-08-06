object Solution {
    def main(args: Array[String]) {
        val lstSize = readInt
        // Create an initial Map object
        var originalDict = readLine.split(" ").map(_.toInt).grouped(2).map(e => (e.head,e.reverse.head)).toMap
        for (i <- 2 to lstSize) {
            var updateDict = readLine.split(" ").map(_.toInt).grouped(2).map(e => (e.head,e.reverse.head)).toMap
            var keys = originalDict.keySet & updateDict.keySet
            originalDict = keys.map(k => k -> math.min( originalDict(k), updateDict(k) )).toMap
        }
        // The output has to be sorted by keys
        val output = originalDict.toList.sortBy(_._1).flatten{case (a,b) => List(a,b)}.mkString(" ")
        println(output)
    }
}