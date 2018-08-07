object Solution {
    def fact(n: BigInt): BigInt = if (n==0) 1 else n * fact(n-1)
    def count(n: BigInt, k: BigInt): BigInt = {
        if(k == 0 || k == n) 1
        else (fact(n) / (fact(n - k) * fact(k))) % 100000007
    }
    def main(args: Array[String]) {
        for(t<-1 to readInt) 
        {
            val nk = readLine.split(" ").map(BigInt(_)).toList
            println(count(nk(0), nk(1)))
        }     
    }
}