/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6178062
 */

fun main() {
   val dataSource = arrayOf(3, 5, 12, 5, 14)
   print(containsPythagorean(dataSource))
}

private fun containsPythagorean(dataSource: Array<Int>): Boolean{
    val squareProduct = dataSource.map { it * it }
    
    dataSource.forEach { firstNumber ->
        dataSource.forEach { secondNumber ->
            if(squareProduct.contains(firstNumber * firstNumber + secondNumber * secondNumber)) return true
        }
    }
    return false
}


