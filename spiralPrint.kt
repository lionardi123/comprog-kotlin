/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191071
 */

enum class Direction(value: Int){
    RIGHT(0),
    BOTTOM(1),
    LEFT(2),
    UP(3)
}

fun main() {
    val dataSource = arrayOf(
    	arrayOf(1,2,3,4,5),
        arrayOf(6,7,8,9,10),
        arrayOf(11,12,13,14,15),
        arrayOf(16,17,18,19,20)
    )
    printSpiral(dataSource)
}

private fun getDirection(currentDirection: Direction): Direction {
    return when(currentDirection) {
        Direction.RIGHT -> Direction.BOTTOM
        Direction.BOTTOM -> Direction.LEFT
        Direction.LEFT -> Direction.UP
        Direction.UP -> Direction.RIGHT
    }
}

private fun nextPosition(currentPosition: Array<Int>,
                     direction: Direction): Array<Int>{
    return when(direction) {
        Direction.RIGHT -> arrayOf(currentPosition[0], currentPosition[1] + 1)
        Direction.BOTTOM -> arrayOf(currentPosition[0] + 1, currentPosition[1])
        Direction.LEFT -> arrayOf(currentPosition[0], currentPosition[1] - 1)
        Direction.UP -> arrayOf(currentPosition[0] - 1, currentPosition [1])
    }
}

private fun isValid(dataSource: Array<Array<Int>>,
                    nextPosition: Array<Int>): Boolean {
    return 0 <= nextPosition[0] &&
           nextPosition[0] < dataSource.size &&
    	   0 <= nextPosition[1] &&
    	   nextPosition[1] < dataSource[0].size &&
    	   dataSource[nextPosition[0]][nextPosition[1]] != Int.MIN_VALUE
}

private fun printSpiral(dataSource: Array<Array<Int>>){
    var totalLoop = dataSource.size * dataSource[0].size
    
    var currentPosition = arrayOf(0,0)
    var direction = Direction.RIGHT
    while(totalLoop > 0) {
        totalLoop -= 1
        
        val currentValue = dataSource[currentPosition[0]][currentPosition[1]]
        dataSource[currentPosition[0]][currentPosition[1]] = Int.MIN_VALUE
        var nextPosition = nextPosition(currentPosition, direction)
        print("$currentValue ")

        if(!isValid(dataSource, nextPosition)) {
             direction = getDirection(direction)
             nextPosition = nextPosition(currentPosition, direction)
        }
        currentPosition = nextPosition       
    }
}

