object Solution {

    // Complete the appendAndDelete function below.
    def commonPrefix(s: String, t: String): String = {
        (s, t).zipped.takeWhile(Function.tupled(_ == _)).map(_._1).mkString
    }
    
    def appendAndDelete(s: String, t: String, k: Int): String = {
        val common = commonPrefix(s, t)
        val diff = s.length + t.length - (2 * common.length)
        if(diff == k) return "Yes"
        else if(diff < k){
            for(t <- 1 to common.length
               if(diff + 2*t == k)) return "Yes"
            if(diff + 2 * common.length < k) return "Yes"
            return "No"
        }
        else return "No"
    }

    def main(args: Array[String]) {
        println(appendAndDelete(readLine, readLine, readInt))
    }
}