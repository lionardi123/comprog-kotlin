/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228685
 */

fun main() {
    val dataSource = arrayOf(-1, 0, 1, 2, -4, -3)
    val dataSourceSet = dataSource.toSet()
    printArray(threeSum(dataSource, dataSourceSet, 0))
}

private fun printArray(dataSource: Array<Int>){
	dataSource.forEach {
        print("$it ")
    }
}

private fun threeSum(dataSource: Array<Int>,
                     dataSourceSet: Set<Int>,
                     targetSum: Int): Array<Int> {
    dataSource.forEachIndexed { index, it ->
        val twoSumResult = twoSum(dataSource, dataSourceSet, targetSum - it, index + 1)
       
        if(twoSumResult.isNotEmpty()) return arrayOf(twoSumResult, arrayOf(it)).flatten().toTypedArray()
    }
    return emptyArray()
}

private fun twoSum(dataSource: Array<Int>,
                   dataSourceSet: Set<Int>,
                   targetSum: Int,
                   startIndex: Int): Array<Int>{
    for(i in startIndex until dataSource.size) {
        val number = dataSource[i]
        if(dataSourceSet.contains(targetSum - number)) return arrayOf(number, targetSum - number)
    }
    
    return emptyArray()
}
