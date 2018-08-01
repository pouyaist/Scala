import scala.util.matching._;
object Solution {
    def main(args: Array[String]) {
        for(i <- 1 to readInt)
        {
            val n: Byte = readByte();
            val pass: String = readLine();
            val attempt: String = readLine();
            val regex: Regex = pass.replaceAll(" ", "|").r;
            val out : String = regex.findAllIn(attempt).mkString("", " ", "");
            val spaces: Int = out.count(_ == ' ');
            if (attempt.length == (out.length - spaces)){
                println(out);
            } else {
                println("WRONG PASSWORD");
            }
            
        }
    }
}