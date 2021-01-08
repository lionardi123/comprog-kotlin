/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6190175
 */

data class Node(
	val value: Int,
    var next: Node? = null
)

fun main() {
   val node = Node(1, Node(2, Node(3, Node(4, Node(5))))) 
   print(removeKthElement(node, 3))
}

fun removeKthElement(node: Node, k: Int): Node {
    
    var helperNode: Node? = node
    for(i in 0 until k) {
        helperNode = helperNode?.next
        if(helperNode == null) return node
    }
    
    var prevNode: Node? = null
	  var targetNode: Node? = node
    
    while(helperNode != null) {
        prevNode = targetNode
        targetNode = targetNode?.next
        helperNode = helperNode?.next
    }
    
   	val nextNode = targetNode?.next
    prevNode?.next = nextNode
    targetNode = null
    
    return node
}
