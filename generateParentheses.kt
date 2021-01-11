/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228792
 */

fun main() {
    print(generateParenthesesBigFunc(3))
}

private fun generateParenthesesBigFunc(totalParentheses: Int): MutableList<String> {
    return generateParentheses(totalParentheses, 0, 0, "")
}

private fun generateParentheses(totalParentheses: Int,
                                totalLeftParentheses: Int,
                                totalRightParentheses: Int,
                                parentheses: String): MutableList<String>{
    val result = mutableListOf<String>()

    if(parentheses.length == totalParentheses * 2) 
    	return mutableListOf(parentheses)
    else {
        if(totalLeftParentheses < totalParentheses)
        	result += generateParentheses(totalParentheses, totalLeftParentheses + 1, totalRightParentheses, parentheses + "(")

        if(totalRightParentheses < totalLeftParentheses)
        	result += generateParentheses(totalParentheses, totalLeftParentheses, totalRightParentheses + 1, parentheses + ")")
    }

    return result
}
