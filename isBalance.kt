import kotlin.math.abs

/**
 https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228797
 */

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)

data class ResultPair(
	val value: Int,
    val isBalance: Boolean
)

private fun constructUnBalanceTree(): Node {
    return Node(1, 
               Node(2,
                   Node(4,
                       Node(6),
                       Node(7)), 
                   Node(5,
                       Node(8),
                       Node(9))),
               Node(3))
}

private fun constructBalanceTree(): Node {
    return Node(1, 
               Node(2,
                   Node(4,
                       Node(6),
                       Node(7)), 
                   Node(5,
                       Node(8),
                       Node(9))),
               Node(3,
                   Node(10),
                   Node(11)))
}

fun main() {
    println(isBalance(constructUnBalanceTree()))
    println(isBalance(constructBalanceTree()))
}

private fun isBalance(node: Node?): ResultPair {
    if(node == null) return ResultPair(0, true)
    
    val resultLeft = isBalance(node?.left)
    val resultRight = isBalance(node?.right)
    
    return ResultPair(
    	maxOf(resultLeft.value, resultRight.value) + 1,
        resultLeft.isBalance && resultRight.isBalance && abs(resultLeft.value - resultRight.value) <= 1
    )
}

