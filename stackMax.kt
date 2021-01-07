/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6178061
 */

class Stack(){
    private val items: MutableList<Int> = mutableListOf()
    private val maxItems: MutableList<Int> = mutableListOf()
    val maxValue: Int
    	get() = if(maxItems.isNotEmpty()) maxItems.last()
        		else -1
    
    fun push(number: Int) {
        items.add(number)
        handleMaxList(number)
    }
    
    private fun handleMaxList(number: Int){
        if(maxItems.isEmpty()) maxItems.add(number)
        else {
            var lastMaxValue = maxItems.last()
            if(lastMaxValue < number) {
                lastMaxValue = number
            }
            maxItems.add(lastMaxValue)
        }
    }
    
    fun pop() {
        items.removeLast()
        maxItems.removeLast()
    }
}

fun main() {
    val stack = Stack().also {
        it.push(1)
        it.push(2)
        it.push(3)
        it.push(2)
        it.pop()
        it.pop()
        it.pop()
        it.pop()
    }
    print(stack.maxValue)
}
