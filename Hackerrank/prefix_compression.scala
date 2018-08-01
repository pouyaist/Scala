object Solution {
    
    def lcp(list: String*) = list.foldLeft("")((_,_) =>
        (list.min.view,list.max.view).zipped.takeWhile(v => v._1 == v._2).unzip._1.mkString)
        
    def prefixCompression(a: String, b: String) = {
        val comSub = lcp(a, b)
        println(comSub.length.toString + " " + comSub)
        println((a.length - comSub.length).toString + " " + a.replace(comSub, ""))
        println((b.length - comSub.length).toString + " " + b.replace(comSub, ""))
    }
    def main(args: Array[String]) {
        prefixCompression(readLine, readLine)
    }
}