/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6231428
 */


fun main() {
	val dataSource = arrayOf(1,2,3)
    permute(dataSource, 0).forEach {
        it.forEach {
            print("$it ")
        }
        println("")
    }
}

private fun permute(dataSource: Array<Int>, start: Int): MutableList<MutableList<Int>> {
    if(start >= dataSource.size - 1) return mutableListOf(dataSource.toMutableList())
    val result = mutableListOf(mutableListOf<Int>())
    for(index in start..dataSource.size - 1) {
        swap(dataSource, index, start)
        result += permute(dataSource, start + 1)
        swap(dataSource, index, start)
    }
    return result
}

private fun swap(dataSource: Array<Int>, index1: Int, index2: Int) {
    val temp = dataSource[index1]
    dataSource[index1] = dataSource[index2]
    dataSource[index2] = temp
}
