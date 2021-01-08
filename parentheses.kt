/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228788
 */

val parenthesesMap = mapOf(')' to '(', 
                           '}' to '{', 
                           ']' to '[')
val openBracketSets = setOf('(','[','{')

fun main() {
    val dataSource = "(){([})}"
    print(validParentheses(dataSource))
}

private fun validParentheses(dataSource: String): Boolean {
    val dataCharArray = dataSource.toCharArray()
    val openBracketList = mutableListOf<Char>()
    dataCharArray.forEach {
        if(openBracketSets.contains(it)) openBracketList.add(it)
        else if(parenthesesMap.get(it) == openBracketList.last()) openBracketList.removeLast()
        else return false
    }
    return openBracketList.isEmpty()
}
