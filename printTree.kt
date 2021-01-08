/**
 * PreOrder PostOrder InOrder
 */

data class Node(
	val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

private fun initDataNode(): Node {
    return Node(1, 
                left = Node(2,
                           left = Node(4),
                           right = Node(5)),
               	right = Node(3))
}

fun main() {
   val dataNode = initDataNode()
   printInOrder(dataNode)
   println("==========")
   
   printPreOrder(dataNode)
   println("==========")
   
   printPostOrder(dataNode)
   println("==========")
}

fun printPreOrder(node: Node?) {
    if(node == null) return
    
    println(node?.value)
    printPreOrder(node.left)
    printPreOrder(node.right)
}

fun printInOrder(node: Node?){
    if(node == null) return
    
    printInOrder(node.left)
    println(node?.value)
    printInOrder(node.right)
}

fun printPostOrder(node: Node?) {
    if(node == null) return
    
    printPostOrder(node.left)
    printPostOrder(node.right)
    println(node?.value)
}
