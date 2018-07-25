import scala.util.control.Breaks
object Solution {
    
    def numberOfWays(v:Int, n:Int):Int = {
        val a=new Array[Int](v+1)
        a(0)=1
        val b = new Breaks
        b.breakable{
            for(i<-1 to v){
                val x=math.pow(i,n).toInt
                if(x>v)b.break
                for(j<-0 to v-x)a(v-j)+=a(v-j-x)
            }
        }
        a(v)
    }

    def main(args: Array[String]) {
       println(numberOfWays(readInt, readInt))
    }
}