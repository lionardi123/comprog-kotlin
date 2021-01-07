/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228781
 */

data class Person(
    val height: Int,
    val numberOfPeople: Int
)

private fun initDataSource(): MutableList<Person>{
    return mutableListOf(
    	Person(7,0),
        Person(4,4),
        Person(7,1),
        Person(5,0),
        Person(6,1),
        Person(5,2)
    )
}

fun main() {
	val dataSource = initDataSource()
    quickSort(dataSource, 0, dataSource.lastIndex)
   	printData(dataSource)
    
    println("")
    
    printData(constructNewOrder(dataSource))
}

private fun constructNewOrder(dataSource: MutableList<Person>): MutableList<Person> {
   val newList = mutableListOf<Person>()
   for(i in dataSource.lastIndex downTo 0) {
       val person = dataSource[i]
       try{
      		newList.add(person.numberOfPeople, person)
       } catch(exception: Exception) {
           newList.add(person)
       }
   }
   return newList
}

private fun printData(dataSource: Collection<Person>){
    dataSource.forEach{
        println("$it")
    }
}

private fun quickSort(dataSource: MutableList<Person>, lowerBound: Int, upperBound: Int){
    if(lowerBound >= upperBound) return 
    var smallerNumberIndex = lowerBound
    for(i in lowerBound until upperBound) {
        if(dataSource[i].height <= dataSource[upperBound].height) {
            swap(dataSource, i, smallerNumberIndex)
            smallerNumberIndex+=1
        } 
    }
    swap(dataSource, upperBound, smallerNumberIndex)
    
    quickSort(dataSource, lowerBound, smallerNumberIndex - 1)
    quickSort(dataSource, smallerNumberIndex + 1, upperBound)
}

private fun swap(dataSource: MutableList<Person>, index1: Int, index2: Int){
    val temp = dataSource[index1]
    dataSource[index1] = dataSource[index2]
    dataSource[index2] = temp
}
