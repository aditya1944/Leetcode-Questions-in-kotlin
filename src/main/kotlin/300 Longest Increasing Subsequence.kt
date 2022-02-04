import kotlin.math.max

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.size == 1) {
        return 1
    }
    val dp = Array(nums.size + 1) { Int.MAX_VALUE }
    dp[0] = Int.MIN_VALUE
    var maxLength = 1
    for (num in nums) {
        var index = dp.binarySearch(num)
        if (index < 0) {
            // num do not exists
            index *= -1
            index -= 1
        } else {

            // find upper bound
            while (index + 1 < dp.size && dp[index + 1] == num) {
                index += 1
            }
        }
        dp[index] = num
        maxLength = max(maxLength, index)
    }
    return maxLength
}

fun main() {
    val l = lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 11, 18))
    println(l)
}