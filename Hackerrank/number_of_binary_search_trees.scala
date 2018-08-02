object Solution {
    def factorial(n: BigInt):BigInt = if (n==0) 1 else n * factorial(n-1)
    def bstNumber(n: BigInt) = {
        (factorial(2*n)/(factorial(n+1) * factorial(n)))% 100000007
    }
    def main(args: Array[String]) {
        for(t<-1 to readInt) println(bstNumber(BigInt(readInt)))
    }
}