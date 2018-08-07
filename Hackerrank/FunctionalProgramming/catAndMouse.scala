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

    // Complete the catAndMouse function below.
    def catAndMouse(x: Int, y: Int, z: Int): String = {
        if(math.abs(z - y) > math.abs(z- x)) "Cat A"
        else if (math.abs(z - y) < math.abs(z- x)) "Cat B"
        else "Mouse C"
    }
    def main(args: Array[String]) {
        for (qItr <- 1 to readInt) {
            val xyz = readLine.split(" ").map(_.trim.toInt)
            val result = catAndMouse(xyz(0), xyz(1), xyz(2))
            println(result)
        }
    }
}