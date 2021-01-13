import kotlin.math.abs

/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191089
 */

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

private fun constructBalanceTree(): Node {
    return Node(0,
                Node(1),
                Node(0,
                    Node(1,
                        Node(1),
                        Node(1)),
                    Node(0))
               )
}

fun main() {
   print(totalUnivalTree(constructBalanceTree()))
}

private fun totalUnivalTree(node: Node?): Int {
    if(node == null) return 0
    
    
    val totalLeftUnival = totalUnivalTree(node?.left)
    val totalRightUnival = totalUnivalTree(node?.right)
    
    var totalUnival = maxOf(totalLeftUnival + totalRightUnival, 1)
        
    if (node?.left != null &&
        node?.right != null &&
        node?.value == node?.left?.value &&
        node?.value == node?.right?.value) {
        totalUnival += 1
    }
    
    return totalUnival
}

