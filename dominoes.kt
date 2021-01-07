/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228784
 */

fun main() {
   val dominoes = IntArray(11) { 0 }
   val rightPush = arrayOf(2, 9)
   val leftPush = arrayOf(6)
      
   pushDominoesRight(dominoes, rightPush, leftPush)
   pushDominoesLeft(dominoes, rightPush, leftPush)
   
   printDomino(dominoes)
}

fun printDomino(dominoes: IntArray){
    dominoes.forEach {
        if(it > 0) print("R")
        else if (it < 0) print("L")
        else print(".")
    }
}

fun pushDominoesRight(dominoes: IntArray, 
                      rightPush: Array<Int>,
                      leftPush: Array<Int>) {
    var currentPower = 0
    for(i in 0 until dominoes.size) {
        if(rightPush.contains(i)) {
            currentPower = dominoes.size
        } else if(leftPush.contains(i)){
            currentPower = 0
        } else if(currentPower != 0){
            currentPower -= 1
        }
        dominoes[i] = currentPower
    }
}

fun pushDominoesLeft(dominoes: IntArray,
                     rightPush: Array<Int>,
                     leftPush: Array<Int>) {
    var currentPower = 0
    for(i in dominoes.lastIndex downTo 0) {
        if(leftPush.contains(i)) {
            currentPower = -dominoes.size
        } else if(rightPush.contains(i)){
            currentPower = 0
        } else if(currentPower != 0){
            currentPower += 1
        }
        dominoes[i] += currentPower
    }
}




