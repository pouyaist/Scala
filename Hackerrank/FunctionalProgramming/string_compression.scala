object Solution {
    def compress[A](ls: List[A]): List[List[A]] = ls match {
            case Nil  => List(List())
            case _  => {
                val (packed, next) = ls span { _ == ls.head }
                if (next == Nil) List(packed)
                else packed :: compress(next)
            }
    }
    def stringCompression(i: String) =
    {
        compress(i.toList).map(t => if (t.size > 1) List(t.head.toString, t.size.toString) else List(t.head)).flatten.mkString
    }
    def main(args: Array[String]) {
        println(stringCompression(readLine))
    }
}