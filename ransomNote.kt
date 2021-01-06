/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6231429
 */

fun initMagazine(): Array<String>{
    return arrayOf(
    	"A",
        "B",
        "C",
        "D",
        "E",
        "F"
    )
}

fun main() {
   val magazine = initMagazine()
   val word = "CAT"
   print(canSpell(magazine, word))
}

fun canSpell(magazine: Array<String>, word: String): Boolean {
    val magazineMap = mutableMapOf<String, Int>()
    magazine.forEach {
        val value = magazineMap.get(it)
        if(value != null) {
            magazineMap.put(it, value + 1)
        } else {
            magazineMap.put(it, 1)
        }
    }
    word.forEach {
        val value = magazineMap.get(it.toString())
        if(value != null && value > 0)
         	magazineMap.put(it.toString(), value - 1)
        else
        	return false
    }
    return true
}
