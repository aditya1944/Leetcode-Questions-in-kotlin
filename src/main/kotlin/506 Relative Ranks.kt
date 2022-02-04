import java.util.*

class Obj(_index: Int, _score: Int) {
    val index = _index
    val score = _score
}

fun findRelativeRanks(score: IntArray): Array<String> {
    val array = Array(score.size) { "" }
    val pq = PriorityQueue { obj1: Obj, obj2: Obj -> obj2.score - obj1.score }
    for (index in score.indices) {
        pq.add(Obj(index, score[index]))
    }
    var currentStatus = 1
    while (!pq.isEmpty()) {
        val top = pq.peek()
        pq.remove()
        when (currentStatus) {
            1 -> array[top.index] = "Gold Medal"
            2 -> array[top.index] = "Silver Medal"
            3 -> array[top.index] = "Bronze Medal"
            else -> array[top.index] = currentStatus.toString()
        }
        ++currentStatus
    }
    return array
}

fun main() {
    val array = findRelativeRanks(intArrayOf(5, 4, 3, 2, 1))
    for (rank in array) {
        println(rank)
    }
}