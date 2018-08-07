object Solution {
    def pentagonalNumber(n: Long): Long = n*(3 * n - 1)/2
    def main(args: Array[String]) {
        for(i <- 1 to readInt) println(pentagonalNumber(readLong))
    }
}