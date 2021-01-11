/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191085
 */

data class Node(
	val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

fun main() {
    print(depthOfBinaryTree(
        Node(1, Node(2, Node(3, Node(4))), Node(5))
        , 0))
}

private fun depthOfBinaryTree(node: Node?,
                              depth: Int): Int {    
    if(node == null) {
        return depth
    }
    
    return maxOf(
    	depthOfBinaryTree(node.left, depth + 1),
        depthOfBinaryTree(node.right, depth + 1)
    ) 
}
