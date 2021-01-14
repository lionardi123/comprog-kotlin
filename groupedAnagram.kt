/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6191090
 */


fun main() {
	val dataSource = arrayOf("abc", "bcd", "cba", "cbd", "efg")
    printGroupAnagram(groupAnagram(dataSource))
}

private fun printGroupAnagram(groupAnagram: MutableMap<String, MutableList<String>>) {
    groupAnagram.forEach {
        print(it.value)
    }
}

private fun groupAnagram(dataSource: Array<String>): MutableMap<String, MutableList<String>> {
    var anagramGroup = mutableMapOf<String, MutableList<String>>()
    dataSource.forEach {
        val stringHashKey = hashKey(it)
        anagramGroup.get(stringHashKey)?.add(it) ?: anagramGroup.put(stringHashKey, mutableListOf(it))
    }
    return anagramGroup
}

private fun hashKey(targetString: String): String {
    var keyList = IntArray(26){0}
  
  	targetString.forEach {
        keyList[it.toInt() - 'a'.toInt()] += 1
    }
    
    return keyList.toList().toString()
}
