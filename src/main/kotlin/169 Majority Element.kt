fun majorityElement(nums: IntArray): Int {
    var majorityElement = nums[0]
    var count = 1
    for (index in 1 until nums.size) {
        if (nums[index] == majorityElement) {
            ++count
        } else {
            --count
        }
        if (count == -1) {
            majorityElement = nums[index]
            count = 1
        }
    }
    return majorityElement
}

fun main() {
    print(majorityElement(intArrayOf(1, 1, 2)))
}