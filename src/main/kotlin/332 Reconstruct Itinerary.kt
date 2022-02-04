import java.util.*


fun findItinerary(tickets: List<List<String>>): List<String> {
    val adjacencyList = HashMap<String, PriorityQueue<String>>()
    for (ticket in tickets) {
        val from = ticket[0]
        val to = ticket[1]

        val fromNeighbours = adjacencyList[from]
        if (fromNeighbours == null) {
            val pq = PriorityQueue<String>()
            pq.add(to)
            adjacencyList[from] = pq
        } else {
            fromNeighbours.add(to)
        }
    }
    val itinerary = ArrayList<String>()
    val stack = Stack<String>()
    stack.push("JFK")
    while (stack.isNotEmpty()) {
        val currCity = stack.peek()
        if (adjacencyList[currCity] == null || adjacencyList[currCity]!!.isEmpty()) {
            // from this city there is no path or all cities have been visited from here
            stack.pop()
            itinerary.add(currCity)
        } else {
            val lexNeighbour = adjacencyList[currCity]!!.poll()
            stack.push(lexNeighbour)
        }
    }

    return itinerary.reversed()
}

fun main() {
    val ticketToFrom = listOf(
        listOf("JFK", "SFO"),
        listOf("JFK", "ATL"),
        listOf("SFO", "ATL"),
        listOf("ATL", "JFK"),
        listOf("ATL", "SFO")
    )

    /*val ticketToFrom = listOf(
        listOf("JFK", "SFO"),
        listOf("JFK", "ATL"),
        listOf("ATL", "JFK"),
    )*/
    val list = findItinerary(ticketToFrom)
    println(list.size)
    for (place in list) {
        println(place)
    }
}