/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191083
 */

class Stack {
    private val items: MutableList<Int> = mutableListOf()
    
    fun push(item: Int) {
        items.add(item)
    }
    
    fun pop(): Int? {
        val lastItem = items.lastOrNull()
        items.removeLastOrNull()
        return lastItem
    }
    
    val stackSize: Int 
        get() = items.size
    
}

fun main() {
   	val dataSource = Stack().also {
        it.push(1)
        it.push(2)
        it.push(3)
        it.push(4)
    }
    val queue = getQueueWithStacks(dataSource)
    for(i in 0 until queue.stackSize) {
        println(queue.pop())
    }
}

fun getQueueWithStacks(dataSource: Stack): Stack {
    val newStack = Stack()
    for(i in 0 until dataSource.stackSize) {
        dataSource.pop()?.let {
        	newStack.push(it)
        }
    }
    return newStack
}
