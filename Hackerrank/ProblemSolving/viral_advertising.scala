import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

    // Complete the viralAdvertising function below.
    def viralAdvertising(n: Int): Int = {
        var peops: Int = 5
        var likes = 0
        for(i <- 1 to n) {
            likes += (peops/2)
            peops = (peops / 2) * 3
        }        
        likes
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn
        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
        val n = stdin.readLine.trim.toInt
        val result = viralAdvertising(n)
        printWriter.println(result)
        printWriter.close()
    }
}
