/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6178059
 */


fun main() {
	arrayOf(
    	3,3,2,1,3,2,1
    ).also {
        sort(it)
        it.forEach {
            print("$it, ")
        }
    }   
}

private fun sort(dataSource: Array<Int>){
    var one_index = 0
    var three_index = dataSource.lastIndex
    var index = 0
    
    while(index <= three_index) {
        val number = dataSource[index]
        if(number == 1) {
            swap(dataSource, index, one_index)
            one_index += 1
            index += 1
        } else if (number == 3) {
            swap(dataSource, index, three_index)
            three_index -= 1
        } else {
            index += 1
        }
    }
}

private fun swap(dataSource: Array<Int>, index1: Int, index2: Int) {
    val temp = dataSource[index1]
    dataSource[index1] = dataSource[index2]
    dataSource[index2] = temp
}
