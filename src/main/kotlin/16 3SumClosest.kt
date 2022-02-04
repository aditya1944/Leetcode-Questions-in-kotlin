fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var closestSum: Int = 0
    var closestDiff = Int.MAX_VALUE
    for (index in 0..nums.size - 3) {
        val requiredSum = target - nums[index]
        var left = index + 1
        var right = nums.size - 1
        while (left < right) {
            val sum = nums[left] + nums[right]
            val currentDiff = kotlin.math.abs(nums[left] + nums[right] + nums[index] - target)
            if (closestDiff > currentDiff) {
                closestDiff = currentDiff
                closestSum = nums[left] + nums[right] + nums[index]
                if (closestSum == target) {
                    return closestSum
                }
            }
            if (sum > requiredSum) {
                --right
            } else {
                ++left
            }
        }
    }
    return closestSum
}

fun main() {
    print(threeSumClosest(intArrayOf(1, 2, 3), 96))
}