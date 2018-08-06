import scala.io.StdIn._
object Solution {

    def main(args: Array[String]) {
        for (t<-1 to readInt)
        {
            var res = Map[String, String]()
            var check = true
            for(a<-1 to readInt)
            {
                var a = readLine.split(" ").toList
                if(res.contains(a(0))) check = false
                else res = res + (a(0) -> a(1))
            }
            if(check) println("YES") else println("NO") 
        }
    }
}