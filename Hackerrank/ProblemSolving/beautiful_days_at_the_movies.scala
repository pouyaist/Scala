import java.io._
import java.util.stream._

object Solution {

    // Complete the beautifulDays function below.
    def beautifulDays(i: Int, j: Int, k: Int): Int = {
        var count = 0
        for(t<-i to j if(math.abs(t - t.toString.reverse.toInt) % k == 0))
            count += 1
        count
    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

        val ijk = stdin.readLine.split(" ")

        val i = ijk(0).trim.toInt

        val j = ijk(1).trim.toInt

        val k = ijk(2).trim.toInt

        val result = beautifulDays(i, j, k)

        printWriter.println(result)

        printWriter.close()
    }
}
