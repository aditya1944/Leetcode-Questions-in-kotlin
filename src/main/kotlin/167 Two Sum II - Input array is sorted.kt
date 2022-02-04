fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.size - 1
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        if (sum < target) {
            ++left
        } else if (sum > target) {
            --right
        } else {
            return intArrayOf(left + 1, right + 1)
        }
    }
    return intArrayOf(-1, -1)
}


fun main() {
    println(twoSum(intArrayOf(2, 7, 11, 15), 9))
}