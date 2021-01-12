/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228795
 */

data class StartEndPair(
    val startTime: Int,
    val endTime: Int
)

fun main() {
	val dataSource = arrayOf(
        StartEndPair(22, 40),
    	StartEndPair(0, 50),
        StartEndPair(20, 30),
        StartEndPair(10, 21),
    )
    dataSource.sortBy { it.startTime }
	print(meetingRooms(dataSource))
}

private fun meetingRooms(dataSource: Array<StartEndPair>): Int {
    var occupiedMeetingRoomSchedule = mutableListOf<StartEndPair>()
    for(i in 0 until dataSource.size){
        val currentSchedule = dataSource[i]
        occupiedMeetingRoomSchedule.add(currentSchedule)
        for(j in i downTo 0){ 
        	val previousSchedule = dataSource[j]
            if(previousSchedule.endTime < currentSchedule.startTime)
            	occupiedMeetingRoomSchedule.remove(previousSchedule)
        }
    }
    
    return occupiedMeetingRoomSchedule.size
}
