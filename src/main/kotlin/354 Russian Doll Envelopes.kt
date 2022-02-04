fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    envelopes.sortWith(compareBy<IntArray> { it[0] }.thenByDescending { it[1] })

    val dp = Array(envelopes.size + 1) { Int.MAX_VALUE }

    dp[0] = 0

    var maxStacked = 1

    for (envelope in envelopes) {
        val height = envelope[1]
        var index = dp.binarySearch(height)
        if (index < 0) {
            // current height is not found
            index *= -1
            index -= 1
        }
        dp[index] = height
        maxStacked = kotlin.math.max(maxStacked, index)
    }
    return maxStacked
}

fun main() {
    val maxStacked = maxEnvelopes(arrayOf(intArrayOf(1, 1), intArrayOf(1, 1), intArrayOf(1, 1)))
    println(maxStacked)
}