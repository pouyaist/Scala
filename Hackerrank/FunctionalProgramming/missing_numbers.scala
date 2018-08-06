object Solution {

  def main(args: Array[String]) {
    val a = readInt
    val list1 = readLine.split(" ").toList
    val b = readInt
    val list2 = readLine.split(" ").toList
    (list1.diff(list2) ++ list2.diff(list1)).distinct.sorted.foreach(i => print(s"${i} "))
  }
}
