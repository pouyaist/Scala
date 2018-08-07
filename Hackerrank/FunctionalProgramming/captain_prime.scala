object Solution {
    def isPrime(n: Int):Boolean = (n > 1) && (! ((2 until n-1) exists (n % _ == 0)))
    
    def allPrimes(a:String, direction:String): Boolean = {
        if(a.length == 1) isPrime(a.toInt)
        else if(isPrime(a.toInt)) {
            if(direction == "left")
                allPrimes(a.drop(1), direction)
            else allPrimes(a.dropRight(1), direction)
        }
        else false 
    }
    def workSection(a: Int): String = {
        if(!a.toString.contains('0'))
        {
            val right = allPrimes(a.toString, "right")
            val left = allPrimes(a.toString, "left")
            if(right && left) "CENTRAL"
            else if(right) "RIGHT"
            else if(left) "LEFT"
            else "DEAD"
            
        }else{
           "DEAD" 
        }
    }
    def main(args: Array[String]) {
        for(i<-1 to readInt) println(workSection(readInt))
        
    }
}