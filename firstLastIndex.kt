/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6178058
 */


fun main() {
	val dataSource = arrayOf(1,3,3,5,7,8,9,9,9,9,9,15)
    arrayOf(
    	binarySearchTree(dataSource, 9, 0, dataSource.size -1, true),
        binarySearchTree(dataSource, 9, 0, dataSource.size -1, false)
    ).forEach{
        print("$it, ")
    }
}

fun binarySearchTree(dataSource: Array<Int>, target: Int, lowerBound: Int, upperBound: Int, isFirst: Boolean): Int{
    if(upperBound < lowerBound) return -1
    val median = lowerBound + (upperBound - lowerBound) / 2
    
    if(isFirst){
    	if(target == dataSource[median] && (median == 0 || dataSource[median - 1] != target)) {
        	return median;
        } else if(target > dataSource[median]){
            return binarySearchTree(dataSource, target, median + 1, upperBound, isFirst);
        } else {
            return binarySearchTree(dataSource, target, lowerBound, median - 1, isFirst);
        }
    } else {
        if(target == dataSource[median] && (median == dataSource.size -1 || dataSource[median + 1] != target)) {
            return median;
        } else if (target < dataSource[median]){
            return binarySearchTree(dataSource, target, lowerBound, median - 1, isFirst);
        } else {
            return binarySearchTree(dataSource, target, median + 1, upperBound, isFirst);
        }
    }
}
