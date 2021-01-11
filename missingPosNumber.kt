/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191086
 */

fun main() {
    print(missingPositiveNumber(arrayOf(3, 4, -1, 1)))
}

private fun missingPositiveNumber(numbers: Array<Int>): Int {
    val numberSet = mutableSetOf<Int>()
    numbers.forEach {
        numberSet.add(it)
    }
    
    for(i in 1..numbers.size) {
        if(!numberSet.contains(i)) return i
    }
    
    return -1
}
