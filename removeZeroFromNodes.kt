/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228791
 */

data class Node(
	val value: Int,
    var next: Node? = null
)

// 3, 1, 2, -1, -2, 4, 1
private fun initDataSource(): Node {
    return Node(3, Node(1, Node(2, Node(-1, Node(-2, Node(4, Node(1)))))))
}

fun main() {
   val node = initDataSource()
   printNode(removeZeroFromLinkedList(node))
}

private fun printNode(node: Node){
    var iteratedNode: Node? = node
    while(iteratedNode != null) {
        println(iteratedNode?.value)
        iteratedNode = iteratedNode?.next
    }
}

private fun removeZeroFromLinkedList(node: Node): Node{
    var orderedMap = linkedMapOf<Int, Node>()
    
	var sum = 0
    var currentNode: Node? = Node(0, node)
   	while(currentNode != null) {
        sum += currentNode?.value ?: 0
        val nodeInMap = orderedMap[sum]
        if(nodeInMap == null) {
            orderedMap[sum] = currentNode
            currentNode = currentNode.next
        } else {
            val prevNode = nodeInMap
            val nextNode = currentNode?.next
            prevNode.next = nextNode
            currentNode = null
        }
    } 
    return node
}
