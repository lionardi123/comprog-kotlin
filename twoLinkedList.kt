/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */

class Node (
	val value: Int
){
    var right: Node? = null
}

fun main() {
   val firstNode = Node(2).also {
        it.right = Node(4)
        it.right?.right = Node(3)
   }
   val secondNode = Node(5).also {
       it.right = Node(6)
       it.right?.right = Node(4)
   }
   
   var total: Node? = addLinkedListNumber(firstNode, secondNode, 0)
   while(total != null) {
       val value = total.value
       print("$value ")
       total = total.right
   }
}

fun addLinkedListNumber(firstNode: Node, secondNode: Node, remain: Int): Node {
    val value = firstNode.value + secondNode.value + remain
    val addition = value / 10
    val result = Node(value % 10)
    
    if(firstNode.right != null || secondNode.right != null) {
        if(firstNode.right == null) 
    		firstNode.right = Node(0)
    	if(secondNode.right == null)
    		secondNode.right = Node(0)
        result.right = addLinkedListNumber(firstNode.right!!, secondNode.right!!, addition)
    } else if (addition != null && addition != 0) {
        result.right = Node(addition)
    }
    
    return result
}
