/**
 * https://www.techseries.dev/products/coderpro/categories/1831147/posts/6228783
 */

class Graph () {
    val nodeList: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    var firstNode: Int = -1
    
    private fun addNode(node: Int){
        if(firstNode == -1) firstNode = node
        nodeList.put(node, mutableSetOf())
    }
    
    fun addEdge(node: Int, edge: Int) {
        var targetNode = nodeList[node]
        if(targetNode == null) {
            addNode(node)
            targetNode = nodeList[node]
        }
        nodeList[node]?.let {
            it.add(edge)
        }
    }
    
    fun getEdgesAt(node: Int): MutableSet<Int>? {
        return nodeList[node]
    }
}

private fun initData(): Graph{
    return Graph().also {
        it.addEdge(0,1)
        it.addEdge(0,2)
        it.addEdge(1,2)
        it.addEdge(2,3)
        it.addEdge(3,0)
    }
}

fun main() {
   val graph = initData()
   print(hasCycle(graph, graph.firstNode))
}

private fun hasCycle(graph: Graph, 
                     currentNode: Int,
                     pendingNode: MutableSet<Int> = mutableSetOf(), 
                     visitedNode: MutableSet<Int> = mutableSetOf()): Boolean {
    if(pendingNode.contains(currentNode)) return true
    if(visitedNode.contains(currentNode)) return false
    
    visitedNode.add(currentNode)
    pendingNode.add(currentNode)
    
   	graph.getEdgesAt(currentNode)?.let { edges ->
        edges.forEach {
            val hasCycle = hasCycle(graph, it, pendingNode, visitedNode)
            if(hasCycle) return true
        }
    }
    
    pendingNode.remove(currentNode)
    return false
}
