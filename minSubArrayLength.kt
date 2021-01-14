import kotlin.math.abs

/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228799
 */


fun main() {
    val dataSource = arrayOf(2,3,1,2,4,3)
    print(minSubArrayLength(dataSource, 111))
}

private fun minSubArrayLength(dataSource: Array<Int>,
                              targetNumber: Int): Int {
    var startIndex = 0
    var endIndex = 0
    var total = dataSource[startIndex]
    var smallestLength = -1
    while(startIndex < dataSource.size ) {
        if(total < targetNumber && endIndex < dataSource.lastIndex){
            endIndex += 1
            total += dataSource[endIndex]
        } else if (total >= targetNumber) {
            smallestLength = endIndex - startIndex
            total -= dataSource[startIndex]
            startIndex += 1
        } else {
            break
        }
    }
    return smallestLength + 1
}
