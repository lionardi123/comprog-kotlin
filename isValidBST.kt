/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6231427
 */

class Node(
	val value: Int
) {
    var left: Node? = null
    var right: Node? = null
}

fun initBST(): Node{
    return Node(5).also{
        it.left = Node(4)
        it.right = Node(7)
        it.right?.left = Node(2)
    }
}

fun main() {
   print(isValidBST(initBST(), Int.MAX_VALUE, Int.MIN_VALUE))
}

fun isValidBST(node: Node?, upperBound: Int, lowerBound: Int): Boolean{
   if(node == null) return true
   
   return (node.value > lowerBound && node.value < upperBound 
           && isValidBST(node.left, node.value, lowerBound) 
            && isValidBST(node.right, upperBound, node.value))
}
