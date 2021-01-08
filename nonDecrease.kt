/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228786
 */


fun main() {
  val dataSource = arrayOf(3,4,2,5,3,6)
  print(isNonDecreasing(dataSource))
}

private fun isNonDecreasing(dataSource: Array<Int>): Boolean {
    var problematicIndex = -1
    
    for(i in 0 until dataSource.lastIndex) {
        val cur = dataSource[i]
        val next = dataSource[i + 1]
        
        if(cur > next) {
            if(problematicIndex != -1) return false
            problematicIndex = i
        }
    }
    
    if(problematicIndex == 0) return true
    else if (problematicIndex == dataSource.size - 2) return true
    else if (dataSource[problematicIndex] <= dataSource[problematicIndex + 2]) return true
    else if (dataSource[problematicIndex - 1] <= dataSource[problematicIndex + 1]) return true
    else return false
}
