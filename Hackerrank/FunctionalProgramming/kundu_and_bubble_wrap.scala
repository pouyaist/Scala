object Solution {
    def sumOfFractions(n: Int): Double = 
        (1 to n).foldLeft(0.0)((r, c) => r + (1.0 / c))
    
    def bubbleWrap(cells: Int): Double = {
        sumOfFractions(cells) * cells.toDouble
    }
    
    def main(args: Array[String]) {
        var cells = readLine.split(" ").map(_.toInt).toList.product
        println(bubbleWrap(cells))
    }
}