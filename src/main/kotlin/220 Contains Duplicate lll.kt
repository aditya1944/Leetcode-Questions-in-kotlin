import java.util.*
import kotlin.math.abs

fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
    val treeSet = TreeSet<Int>()

    for ((index, num) in nums.withIndex()) {
        val nextLargerNumber = treeSet.ceiling(num)
        val nextSmallerNumber = treeSet.floor(num)
        if ((nextLargerNumber != null && abs(num.toLong() - nextLargerNumber) <= t) || (nextSmallerNumber != null && abs(
                num.toLong() - nextSmallerNumber
            ) <= t)
        ) {
            return true
        }
        if (index >= k) {
            treeSet.remove(nums[index - k])
        }
        treeSet.add(num)
    }
    return false
}

fun main() {
    println(containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3))
}