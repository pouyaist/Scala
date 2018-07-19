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

    // Complete the sockMerchant function below.
    def sockMerchant(ar: Array[Int]): Int = {
        ar.groupBy(t => t).mapValues(_.size).filter(t => t._2 > 1).map(t => t._2/2).sum
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val n = stdin.readLine.trim.toInt

        val ar = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = sockMerchant(ar)

        printWriter.println(result)

        printWriter.close()
    }
}