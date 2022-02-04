fun sortArrayByParityII(nums: IntArray): IntArray {
    var oddIndex = 1
    for (evenIndex in nums.indices step 2) {
        if (nums[evenIndex] % 2 != 0) {
            //odd element at even place
            while (nums[oddIndex] % 2 != 0) {
                oddIndex += 2
            }
            // even element at odd place
            val temp = nums[oddIndex]
            nums[oddIndex] = nums[evenIndex]
            nums[evenIndex] = temp
        }
    }
    return nums
}

fun main() {
    val arr = sortArrayByParityII(intArrayOf(4, 2, 5, 7))
    for (num in arr) {
        println(num)
    }
}