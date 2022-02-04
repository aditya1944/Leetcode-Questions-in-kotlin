fun rotate(nums: IntArray, k: Int): Unit {
    val modifiedK = k % nums.size
    if (modifiedK == 0) {
        return
    }
    reverse(nums)
    reverse(nums, 0, modifiedK - 1)
    reverse(nums, modifiedK, nums.size - 1)
}

fun reverse(arr: IntArray, left1: Int = 0, right1: Int = arr.size - 1) {
    var left = left1
    var right = right1
    while (left < right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        ++left
        --right
    }
}

fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotate(array, 3)
    for (num in array) {
        println(num)
    }
}