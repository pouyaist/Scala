object Solution {

    def last[A](ls: List[A]): A = ls.last

    def penultimate[A](ls: List[A]): A =
        if (ls.isEmpty) throw new NoSuchElementException
        else ls.init.last

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

    def pack[A](ls: List[A]): List[List[A]] = ls match {
        case Nil  => List(List())
        case _  => {
            val (packed, next) = ls span { _ == ls.head }
            if (next == Nil) List(packed)
            else packed :: pack(next)
        }
    }

    def encode[A](ls: List[A]): List[(Int, A)] = for( p <- pack(ls)) yield (p.length, p.head)
    def encodeMap[A](ls: List[A]): List[(Int, A)] = pack(ls) map { e => (e.length, e.head) }

    def encodeModified[A](ls: List[A]): List[Any] = for( p <- pack(ls)) yield {if (p.length == 1) p.head else (p.length, p.head)}
    def encodeModifiedMap[A](ls: List[A]): List[Any] = encode(ls) map { t => if (t._1 == 1) t._2 else t }
    
    def decode[A](ls: List[(Int, A)]): List[Any] = {
        ls.flatMap {t => for(i<-1 to t._1) yield t._2}
    }

    def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
        if (ls.isEmpty) Nil
        else {
            val (packed, next) = ls span { _ == ls.head }
            (packed.length, packed.head) :: encodeDirect(next)
        }
    }   

    def duplicate[A](ls: List[A]): List[(A)] = ls.flatMap {t => List(t,t)}
    def duplicateN[A](n: Int, ls: List[A]): List[(A)] = ls.flatMap {t => List.fill(n)(t)}

    def drop[A](n: Int, ls: List[A]): List[(A)] = if (ls.size < n) ls else ls.take(n - 1) ++ ls.drop(n)

    def split[A](n: Int, ls: List[A]): (List[A], List[A])  = ls.splitAt(n)
    def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) = (ls.take(n), ls.drop(n))

    def slice[A](n: Int, k: Int, ls: List[A]): List[A] = ls.slice(n, k)
    def sliceFunctional[A](s: Int, e: Int, ls: List[A]): List[A] =   ls drop s take (e - (s max 0))

    def rotate[A](r: Int, ls: List[A]) = 
    {
        if (r > 0) ls.drop(r) ++ ls.take(r) 
        else ls.takeRight(math.abs(r)) ++ ls.reverse.drop(math.abs(r)).reverse
    }

    def removeAt[A](n: Int, ls: List[A]): (List[(A)], A) = 
    {
        if (n < 0) throw new NoSuchElementException
        else (n, ls) match {
            case (_, Nil) => throw new NoSuchElementException
            case (_, _) => (ls.take(n) ++ ls.drop(n + 1), ls.drop(n).head)
        }
    }

    def insertAt[A](k: A, n: Int,  ls: List[A]): List[A] = ls.take(n) ::: k :: ls.drop(n)
    def insertAtWithSplit[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
        case (pre, post) => pre ::: e :: post
    }

    def range(s: Int, e: Int): List[Int] = (s to e).toList 

    def randomSelect[A](n: Int, ls: List[A]): List[A] = {
        if(n <= 0) Nil
        else {
            val r = scala.util.Random
            val removeRes = removeAt(r.nextInt(ls.length), ls)
            removeRes._2 :: randomSelect(n - 1, removeRes._1)
        }
    }

    def lotto(rand: Int, rangeNumber:Int): List[(Int)] = randomSelect(rand, range(1, rangeNumber))

    def randomPermute[A](ls: List[A]): List[A]  = scala.util.Random.shuffle(ls)

    def combinations[A](n: Int, ls: List[A]): List[List[A]] = {
        if (n > ls.length) Nil
        else ls match {
            case _ :: _ if n == 1 =>
                ls.map(List(_))
            case head :: tail =>
                combinations(n - 1, tail).map(head :: _) ::: combinations(n, tail)
            case _ => Nil
        }
    }

  //p27 was super hard, could not figure it out
}

