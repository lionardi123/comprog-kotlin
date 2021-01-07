/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228782
 */

data class Node(
    val value: Int,
    var next: Node?
)

private fun initDataSource(): Node{
    return Node(1, Node(2, Node(3, Node(4, Node(5, null)))))
}

fun main() {
	val dataSource = initDataSource()
    print(reverse(dataSource))
}

fun reverse(node: Node): Node? {
    var currentNode: Node? = node
    var prevNode: Node? = null
    
    while(currentNode != null) {
       val tempNode = currentNode.next
       currentNode.next = prevNode
       prevNode = currentNode 
       currentNode = tempNode 
    }
    return prevNode
}
