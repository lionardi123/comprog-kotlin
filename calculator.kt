/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6190116
 */

data class CalcResult(val result: Int,
           val lastIndex: Int)

fun main() {
  val arguments = "-(-1+(3+(2-1)))"
  print(calculator(arguments, 0))
}

private fun calculator(arguments: String,
                     startIndex: Int): CalcResult{
    var operands = mutableListOf<Int>()
    var mathOperator: Char? = null
    
    var currentIndex = startIndex
    var result = 0
    while(currentIndex < arguments.length) {
        val currentItem = arguments.get(currentIndex)
        if(currentItem.isDigit()) {
            operands.add(Character.getNumericValue(currentItem.toInt()))
        } else if(currentItem == '-' || currentItem == '+') {
            mathOperator = currentItem
        } else if(currentItem == '('){
            val calcResult = calculator(arguments, currentIndex + 1)
            operands.add(calcResult.result)
            currentIndex = calcResult.lastIndex
        } else if (currentItem == ')'){
            return CalcResult(result, currentIndex)
        }
        
        if(operands.isNotEmpty() && mathOperator != null) {
            result += calculate(operands, mathOperator)
            operands.clear()
            mathOperator = null
        } 
        currentIndex++
    }
    return CalcResult(result, currentIndex)
}

private fun calculate(operands: MutableList<Int>,
                      mathOperator: Char): Int{
    if(operands.size == 1 && mathOperator == '-') {
        return -operands[0]
    } else if(operands.size == 2 && mathOperator == '-') {
        return operands[0] - operands[1]
    } else if (operands.size == 2 && mathOperator == '+') {
        return operands[0] + operands[1]
    } else {
        return operands[0]
    }
}

