/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228794
 */

data class Node(
	val value: Int,
    val next: Node? = null
)

fun main() {
    val firstNode = Node(1, Node(2, Node(3, Node(4))))
    val secondNode = Node(5, Node(3, Node(4)))
    print(intersectTwoLinkedList(firstNode, secondNode))
}

private fun intersectTwoLinkedList(firstNode: Node,
                                   secondNode: Node): Int {    
   
   	var counterFirst = 0
    var currentFirstNode: Node? = firstNode
    while(currentFirstNode?.next != null){
        currentFirstNode = currentFirstNode?.next
        counterFirst += 1
    }
    currentFirstNode = firstNode
    
    var counterSecond = 0
    var currentSecondNode: Node? = secondNode
    while(currentSecondNode?.next != null){
        currentSecondNode = currentSecondNode?.next
        counterSecond += 1
    }
    currentSecondNode = secondNode
    
    val diff = Math.abs(counterFirst - counterSecond)
    if(counterFirst > counterSecond) {
        for(i in 0 until diff)
        	currentFirstNode = currentFirstNode?.next
    } else if(counterSecond > counterFirst) {
        for(i in 0 until diff)
        	currentSecondNode = currentSecondNode?.next
    }
    
    for(i in diff until counterFirst) {
        if(currentFirstNode?.value == currentSecondNode?.value) return currentFirstNode?.value ?: -1
        currentFirstNode = currentFirstNode?.next
        currentSecondNode = currentSecondNode?.next
    }
    
    return -1
}
