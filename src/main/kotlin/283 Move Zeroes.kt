fun moveZeroes(nums: IntArray): UInt {
    var lastIndexOfNonZero = -1
    for (index in nums.indices) {
        if (nums[index] != 0) {
            ++lastIndexOfNonZero
            nums[lastIndexOfNonZero] = nums[index]
        }
    }
    ++lastIndexOfNonZero
    while (lastIndexOfNonZero < nums.size) {
        nums[lastIndexOfNonZero] = 0
        ++lastIndexOfNonZero
    }
    return lastIndexOfNonZero.toUInt()
}

fun main() {
    val arr = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(arr)
    for (num in arr) {
        print(num)
    }
}