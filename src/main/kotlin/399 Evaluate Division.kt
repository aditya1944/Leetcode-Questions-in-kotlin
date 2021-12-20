import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    val adjacencylist = HashMap<String, HashMap<String, Double>>()
    for ((index, equation) in equations.withIndex()) {
        val value = values[index]
        val a = equation[0]
        val b = equation[1]
        val aNeighbour = adjacencylist[a]
        if (aNeighbour == null) {
            adjacencylist[a] = hashMapOf(b to value)
        } else {
            aNeighbour[b] = value
        }
        val bNeighbour = adjacencylist[b]
        if (bNeighbour == null) {
            adjacencylist[b] = hashMapOf(a to 1 / value)
        } else {
            bNeighbour[a] = 1 / value
        }
    }

    val ansArray = arrayListOf<Double>()

    for (query in queries) {
        val startVertex = query[0]
        val endVertex = query[1]
        ansArray.add(findAns(startVertex, endVertex, adjacencylist))
        // traverse from startNode to endNode
    }

    return ansArray.toDoubleArray()
}

fun findAns(startVertex: String, endVertex: String, adjacencyList: HashMap<String, HashMap<String, Double>>): Double {
    if (adjacencyList[startVertex] == null || adjacencyList[endVertex] == null) {
        return -1.0
    }
    val stack = Stack<Pair<String, Double>>()
    val visited = HashSet<String>()
    stack.push(Pair(startVertex, 1.0))
    visited.add(startVertex)
    while (stack.isNotEmpty()) {
        val topNode = stack.pop()
        if (topNode.first == endVertex) {
            return topNode.second
        }
        val neighbours = adjacencyList[topNode.first]
        if (neighbours != null) {
            for (neighbour in neighbours) {
                if (!visited.contains(neighbour.key)) {
                    visited.add(neighbour.key)
                    stack.push(Pair(neighbour.key, topNode.second * neighbour.value))
                }
            }
        }
    }

    return -1.0
}
