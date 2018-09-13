object Solution {

    // Complete the jumpingOnClouds function below.
    def jumpingOnClouds(c: List[Int], k: Int): Int = {
        var e: Int = 100
        var land: Int = 0
        do {
           land = if(land + k >= c.length ) 0 else land + k;
           if(c(land) == 1) e -= 2
            e -=1
        } 
        while(land != 0);
        e
    }

    def main(args: Array[String]) {
        val nk = readLine.split(" ")
        val n = nk(0).toInt
        val k = nk(1).toInt
        val c = readLine.split(" ").map(_.toInt).toList
        val result = jumpingOnClouds(c, k)
        println(result)
    }
}