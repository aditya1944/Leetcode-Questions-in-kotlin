fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
    val dp = Array<Array<Int>>(multipliers.size + 1) { Array<Int>(multipliers.size + 1) { 0 } }

    for (mIndex in multipliers.size - 1 downTo 0) {
        for (left in mIndex downTo 0) {
            val right = nums.size - 1 - (mIndex - left)
            dp[mIndex][left] = kotlin.math.max(
                dp[mIndex + 1][left + 1] + nums[left] * multipliers[mIndex],
                dp[mIndex + 1][left] + nums[right] * multipliers[mIndex]
            )
        }
    }
    return dp[0][0]
}

fun main() {
    println(maximumScore(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
}