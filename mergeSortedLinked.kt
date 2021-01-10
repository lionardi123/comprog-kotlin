/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191084
 */

data class Node(
	val value: Int,
    var next: Node? = null
)

fun main() {
   val nodeA = Node(1, Node(3, Node(5)))
   val nodeB = Node(2, Node(4, Node(6)))
   printNode(mergeSortedLinkedList(nodeA, nodeB)!!)
}

private fun mergeSortedLinkedList(nodeA: Node,
                                  nodeB: Node): Node? {
    var currentNodeA: Node? = nodeA
    var currentNodeB: Node? = nodeB
    var resultNode: Node? = null
    var firstResultNode: Node? = null
    while(currentNodeA != null || currentNodeB != null) {
  
        if(currentNodeA != null && currentNodeB != null) {
            val toBeInserted = if(currentNodeA.value < currentNodeB.value){
                                    val inserted = currentNodeA
                                    currentNodeA = currentNodeA.next
                                    inserted
                                } else {
                                    val inserted = currentNodeB
                                    currentNodeB = currentNodeB.next
                                    inserted
                                }
            
            if(resultNode == null){
                resultNode = toBeInserted
                firstResultNode = resultNode
            } else {
                resultNode.next = toBeInserted
                resultNode = resultNode.next
            }
        } else if(currentNodeA != null) {
            val inserted = currentNodeA
            currentNodeA = currentNodeA.next
            if(resultNode == null) {
                resultNode = inserted
                firstResultNode = resultNode
            } else {
                resultNode.next = inserted
                resultNode = resultNode.next
            }
        } else if (currentNodeB != null) {
            val inserted = currentNodeB
            currentNodeB = currentNodeB.next
            if(resultNode == null) {
                resultNode = inserted
                firstResultNode = resultNode
            } else {
                resultNode.next = inserted
                resultNode = resultNode.next
            }
        }
    }
    return firstResultNode
}

private fun printNode(node: Node) {
    var currentNode: Node? = node
    while(currentNode != null) {
        println(currentNode.value)
        currentNode = currentNode.next
    }
}
