/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191088
 */

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

fun main() {
    val tree = Node(1, 
                    Node(2,
                         Node(4), Node(5)), 
                    Node(3,
                         Node(7)))
    print(nodesAtDepth(tree, 1, 1))
}

private fun nodesAtDepth(node: Node?, 
                         currentDepth: Int,
                         targetDepth: Int): MutableList<Int> {
    var result = mutableListOf<Int>()
    if(node == null) return result
    if(currentDepth == targetDepth)
    	result.add(node.value)
    else {
        result.addAll(nodesAtDepth(node.left, currentDepth + 1, targetDepth))
        result.addAll(nodesAtDepth(node.right, currentDepth + 1, targetDepth))
    }    
    return result
}
