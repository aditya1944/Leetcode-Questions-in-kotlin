import java.util.*

fun findCircleNum(isConnected: Array<IntArray>): Int {
    var provinceCount = 0

    if (isConnected.isEmpty()) {
        return 0
    }
    val visited = HashSet<Int>()

    for (vertex in isConnected.indices) {
        if (!visited.contains(vertex)) {
            dfs(isConnected, vertex, visited)
            ++provinceCount
        }
    }
    return provinceCount
}

fun dfs(adjacencyMatrix: Array<IntArray>, startVertex: Int, visited: HashSet<Int>) {
    val stack = Stack<Int>()
    stack.push(startVertex)

    while (stack.isNotEmpty()) {
        val topVertex = stack.pop()

        for ((vertex, isEdgeExists) in adjacencyMatrix[topVertex].withIndex()) {
            if (isEdgeExists == 1 && !visited.contains(vertex)) {
                stack.push(vertex)
                visited.add(vertex)
            }
        }
    }
}
