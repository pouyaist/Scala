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

    // Complete the taumBday function below.
    def taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Int = {
        if(bc + z < wc) (b + w)* bc + w * z
        else if(wc + z < bc) (b + w)* wc + b * z
        else b * bc + w * wc

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val t = stdin.readLine.trim.toInt

        for (tItr <- 1 to t) {
            val bw = stdin.readLine.split(" ")

            val b = bw(0).trim.toInt

            val w = bw(1).trim.toInt

            val bcWcz = stdin.readLine.split(" ")

            val bc = bcWcz(0).trim.toInt

            val wc = bcWcz(1).trim.toInt

            val z = bcWcz(2).trim.toInt

            val result = taumBday(b, w, bc, wc, z)

            printWriter.println(result)
        }

        printWriter.close()
    }
}
