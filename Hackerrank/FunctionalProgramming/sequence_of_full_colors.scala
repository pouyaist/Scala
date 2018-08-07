object Solution {

  def testFullColor(str:String):String = {
    def testFullColorRec(countTuple:Tuple4[Int,Int,Int,Int], strTail:List[Char]):String = {
      if(strTail.isEmpty)
        if(countTuple._1 == countTuple._2 && countTuple._3 == countTuple._4)
          "True"
        else
          "False"
      else if((countTuple._1 - countTuple._2).abs > 1 ||  (countTuple._3 - countTuple._4).abs > 1)
        "False"
      else{
        if(strTail.head == 'R')
          testFullColorRec(countTuple.copy(_1 = countTuple._1+1), strTail.tail)
        else if(strTail.head == 'G')
          testFullColorRec(countTuple.copy(_2 = countTuple._2+1), strTail.tail)
        else if(strTail.head == 'Y')
          testFullColorRec(countTuple.copy(_3 = countTuple._3+1), strTail.tail)
        else
          testFullColorRec(countTuple.copy(_4 = countTuple._4+1), strTail.tail)
      }
    }
    testFullColorRec((0,0,0,0), str.toList)
  }
  def main(args: Array[String]) {
    for (t <- 1 to readInt)
    {
      println(testFullColor(readLine))
    }
  }
}