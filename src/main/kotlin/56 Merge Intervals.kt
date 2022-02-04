fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortedBy { it[0] }
    var index = 1
    val newIntervalList = ArrayList<IntArray>()
    newIntervalList.add(intervals[0])
    while (index < intervals.size) {
        val currentInterval = intervals[index]
        val lastInterval = newIntervalList.last()
        if (currentInterval[0] < lastInterval[1]) {
            // current interval can be merged to previous interval
            lastInterval[1] = kotlin.math.max(lastInterval[1], currentInterval[1])
        } else {
            newIntervalList.add(intervals[index])
        }
        ++index
    }
    return newIntervalList.toTypedArray()
}

fun main() {

}