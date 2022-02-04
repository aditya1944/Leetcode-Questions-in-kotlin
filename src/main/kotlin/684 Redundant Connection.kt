import java.util.*

fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val adjacencyMatrix = HashMap<Int, ArrayList<Int>>()
    var returnValue = intArrayOf(-1, -1)
    for ((index, edge) in edges.withIndex()) {
        val startVertex = edge[0]
        val endVertex = edge[1]

        // traverse the graph and see if endVertex can be reached from startVertex
        val canBeReached = dfs(adjacencyMatrix, startVertex, endVertex)

        if (canBeReached) {
            returnValue = edges[index]
            break
        }
    }
    return returnValue

}

fun dfs(adjacencyMatrix: HashMap<Int, ArrayList<Int>>, startVertex: Int, endVertex: Int): Boolean {
    if (startVertex == endVertex) {
        return true
    }
    val stack = Stack<Int>()
    val visited = HashSet<Int>()
    stack.push(startVertex)
    visited.add(startVertex)
    while (stack.isNotEmpty()) {
        val topVertex = stack.pop()
        val neighbours = adjacencyMatrix[topVertex] ?: break
        for (neighbour in neighbours) {
            if (!visited.contains(neighbour)) {
                if (neighbour == endVertex) {
                    return true
                }
                visited.add(neighbour)
                stack.push(neighbour)
            }
        }
    }

    val neighbour1 = adjacencyMatrix[startVertex]
    if (neighbour1 == null) {
        adjacencyMatrix[startVertex] = arrayListOf(endVertex)
    } else {
        neighbour1.add(endVertex)
    }

    val neighbour2 = adjacencyMatrix[endVertex]
    if (neighbour2 == null) {
        adjacencyMatrix[endVertex] = arrayListOf(startVertex)
    } else {
        neighbour2.add(startVertex)
    }

    return false
}
