/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6190177
 */

fun main() {
    val dataSource = arrayOf(3, 5, 2, 4, 6, 8)
    val k = 3
    print(findKLargestElement(dataSource, 0, dataSource.size - 1, dataSource.size - k))
}

fun findKLargestElement(dataSource: Array<Int>,
                        lowBound: Int,
                        upperBound: Int,
                        index: Int): Int{
    if(lowBound == upperBound) return dataSource[lowBound]
    
    var smallestIndex = lowBound
    
    for(i in lowBound until upperBound) {
        val pivotValue = dataSource[upperBound]
        val currentValue = dataSource[i]
        if(currentValue <= pivotValue) {
            swap(dataSource, i, smallestIndex)
            smallestIndex+=1
        } 
    }
    swap(dataSource, upperBound, smallestIndex)

    if(smallestIndex == index) {
        return dataSource[smallestIndex]
    } else if (index > smallestIndex) {
        return findKLargestElement(dataSource,
                                   smallestIndex + 1,
                                   upperBound,
                                   index)
    } else {
        return findKLargestElement(dataSource,
                                   lowBound,
                                   upperBound - 1,
                                   index)
    }
}

fun swap(dataSource: Array<Int>, 
         index1: Int,
         index2: Int) {
    val temp = dataSource[index1]
    dataSource[index1] = dataSource[index2]
    dataSource[index2] = temp
}

private fun printArray(dataSource: Array<Int>){
    dataSource.forEach {
        print("$it ")
    }
    println("")
}
