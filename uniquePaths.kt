/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228790
 */

fun main() {
    print(uniquePaths(2,4))
}

private fun uniquePaths(yCoordinate: Int, 
                        xCoordinate: Int): Int {
    var currentXCoordinate = 0
    var currentYCoordinate = 0
    
    val matrix = mutableListOf(mutableListOf<Int>())
    while(currentXCoordinate <= xCoordinate 
         || currentYCoordinate < yCoordinate) {
                println("$currentYCoordinate $currentXCoordinate")

        if(currentXCoordinate == 0 || currentYCoordinate == 0) {
        	matrix[currentYCoordinate].add(1)
        } else {
        	matrix[currentYCoordinate].add(matrix[currentYCoordinate][currentXCoordinate - 1] 
                                           + matrix[currentYCoordinate - 1][currentXCoordinate])
        }
    	if(currentXCoordinate == xCoordinate 
           && currentYCoordinate < yCoordinate) {
            currentXCoordinate = 0
            currentYCoordinate += 1
            matrix.add(mutableListOf())
        } else {
            currentXCoordinate += 1
        }
    }
    
    return matrix.last().last()
}
