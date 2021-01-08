/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228785
 */


fun main() {
  val dataSource = arrayOf(1,2,3,4)
  printArray(productExceptSelf(dataSource))
}

fun printArray(dataSource: Array<Int>){
    dataSource.forEach {
        print("$it ")
    }
}

fun productExceptSelf(dataSource: Array<Int>): Array<Int> {
    val result = arrayOf(1,1,1,1)
    
    var product = 1
    for(i in 1 until dataSource.size) {
        product *= dataSource[i - 1]
        result[i] = product
    }
    
    product = 1
    for(i in dataSource.size - 2 downTo 0) {
       product *= dataSource[i + 1]
       result[i] *= product 
    }
    
  	return result
}

