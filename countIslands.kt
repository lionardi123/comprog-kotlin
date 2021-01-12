/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228796
 */

private fun createMap(): Array<Array<Boolean>> {
    return arrayOf(
        arrayOf(true, true, false, false, false),
        arrayOf(false, true, false, false, true),
        arrayOf(true, false, false, true, true),
        arrayOf(false, false, false, false, false)
    )
}

fun main() {
    val dataSource = createMap()
    print(countIslands(dataSource,
                       mutableSetOf()))
}

private fun countIslands(map: Array<Array<Boolean>>,
                         seenCoordinate: MutableSet<String>): Int {
    var islandCount = 0
    for(i in 0 until map.size) {
        for(j in 0 until map[0].size) {
            val isLand = map[i][j]
            if(isLand && !seenCoordinate.contains("$i,$j")) {
                islandCount += 1
                exploreIsland(map, seenCoordinate, i, j)
            }
        }
    }
    return islandCount
}

private fun exploreIsland(map: Array<Array<Boolean>>,
                          seenCoordinate: MutableSet<String>,
                          yCoordinate: Int,
                          xCoordinate: Int){
    if(yCoordinate >= map.size ||
            yCoordinate < 0 ||
            xCoordinate >= map[0].size ||
            xCoordinate < 0 ||
            !map[yCoordinate][xCoordinate] ||
            seenCoordinate.contains("$yCoordinate,$xCoordinate")) {
        return
    }
    seenCoordinate.add("$yCoordinate,$xCoordinate")

    exploreIsland(map, seenCoordinate, yCoordinate + 1, xCoordinate)
    exploreIsland(map, seenCoordinate, yCoordinate - 1, xCoordinate)

    exploreIsland(map, seenCoordinate, yCoordinate, xCoordinate + 1)
    exploreIsland(map, seenCoordinate, yCoordinate, xCoordinate - 1)
}
