fun containsDuplicate(nums: IntArray): Boolean {
    val set = HashSet<Int>()
    for (num in nums) {
        if (set.contains(num)) {
            return true
        }
        set.add(num)
    }
    return false
}

fun main() {
    print(containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}