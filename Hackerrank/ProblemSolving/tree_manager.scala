import scala.collection.mutable.ArrayBuffer
object Solution {
    class Tree(var value: Int, var left: Option[Tree], var right: Option[Tree], var children: Option[ArrayBuffer[Tree]], var parent: Option[Tree])
    
    def main(args: Array[String]) {
        var root = new Tree(0, None, None, None, None)
        for(t <- 1 to readInt){
            var instruction = readLine.split(" ").toList
            //println(instruction)
            instruction(0) match {
                case "print" =>  println(root.value)
                case "delete" => if(root.parent != None) 
                {
                    root.parent.get.children = Some(root.parent.get.children.get - root)
                    root = root.parent.get  
                }
                case "change" => root.value = instruction(1).toInt
                case "insert" => 
                {
                    instruction(1) match {
                        case "child" => {
                            if(root.children == None) root.children = Some(ArrayBuffer(new Tree(instruction(2).toInt, None, None, None, Some(root))))
                            else root.children = Some(root.children.get :+ new Tree(instruction(2).toInt, None, None, None, Some(root)))
                        }
                        case "left" =>
                        {
                            root.left = Some(new Tree(instruction(2).toInt, None, Some(root), None, root.parent))
                            root.parent.get.children = Some(root.parent.get.children.get :+ root.left.get)
                        }
                        case "right" => 
                        {
                            root.right = Some(new Tree(instruction(2).toInt, Some(root), None, None, root.parent))
                            root.parent.get.children = Some(root.parent.get.children.get :+ root.right.get)
                        }
                  }
                }
                case "visit" => {
                    instruction(1) match{
                        case "parent" =>
                             if(root.parent != None) root = root.parent.get
                        case "child" =>
                             if(root.children != None) root = root.children.get(instruction(2).toInt - 1)
                        case "left" =>
                             if(root.left != None) root = root.left.get
                        case "right" =>
                             if(root.right != None) root = root.right.get
                    }
                   
                }
            }
        }
    }
}