/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228789
 */


fun main() {
	val dataSource = arrayOf(
    	2,7,11,15
    )   
    twoSum(dataSource, 17).forEach {
        println(it)
    }
}

fun twoSum(dataSource: Array<Int>, target: Int): Array<Int> {
    val mapSource = mutableMapOf<Int, Int>()
    dataSource.forEachIndexed { index, number ->
        if(mapSource[number] != null) {
            return arrayOf(index, mapSource[number]!!)
        } else {
            mapSource[target - number] = index
        }
    }
    return arrayOf(-1, -1)
}
