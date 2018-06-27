object Solution {
    def nth(k: Int, lst: List[Int]): Int = {
        if (k < 0) throw new IllegalArgumentException
        if (lst.length < k) throw new NoSuchElementException
        lst(k)       
    }
    def length(lst: List[Int]): Int = lst.length
    def reverse(lst: List[Int]): List[Int] = lst.reverse
    def isPalindrome(lst: List[Int]): Boolean =  lst == lst.reverse
    def flatten(l: List[Any]): List[Any] = l match {
        case Nil => Nil
        case (h:List[_])::tail => flatten(h):::flatten(tail)
        case h::tail => h::flatten(tail)
    }
    def flattenOptimized(ls: List[Any]): List[Any] = ls flatMap {
        case ms: List[_] => flatten(ms)
        case e => List(e)
    }
    def compress[T](lst:List[T]):List[T] = {
        lst match {
            case head::tail => { 
                val (duplst,remainlst) = lst.span(_ == head)
                duplst.head :: compress(remainlst) 
            }
            case Nil => Nil
        }
    }
    def compressRecursive[A](ls: List[A]): List[A] = ls match {
        case Nil       => Nil
        case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
    }

    def compressFunctional[A](ls: List[A]): List[A] =
        ls.foldRight(List[A]()) { (h, r) =>
        if (r.isEmpty || r.head != h) h :: r
        else r
    }   
}