/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6190118
 */

class Grid(
	val matrix: Array<Array<Char>>
){
    
    fun wordSearch(words: Array<Char>): Boolean {
        return searchRight(words) || searchBottom(words)
    }
    
    fun searchRight(words: Array<Char>): Boolean {
        var wordIndex = 0
        for(i in 0 until matrix.size){
            for(j in 0 until matrix.size) {
                if(matrix[i][j] != words[wordIndex]) return false
                else wordIndex +=1
                
                if(wordIndex == words.size) return true
            }
        }
        return true
    }
    
    private fun searchBottom(words: Array<Char>): Boolean {
        var wordIndex = 0
        for(i in 0 until matrix.size){
            for(j in 0 until matrix.size) {
                if(matrix[j][i] != words[wordIndex]) return false
                else wordIndex +=1
                
                if(wordIndex == words.size) return true
            }
        }
        return true
    }
}

fun main() {
   val matrix = arrayOf(
   	 	arrayOf('F', 'A', 'C', 'I'),
        arrayOf('O', 'B', 'Q', 'P'),
        arrayOf('A', 'N', 'O', 'B'),
        arrayOf('M', 'A', 'S', 'S')
   )
   print(Grid(matrix).wordSearch(arrayOf('B', 'N', 'A')))
}
