fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val hashMap = HashMap<Int, Int>()
    for (num in nums1) {
        hashMap[num] = hashMap.getOrDefault(hashMap[num], 0) + 1
    }
    val array = mutableListOf<Int>()
    for (num in nums2) {
        val currentFreq = hashMap.getOrDefault(num, Int.MIN_VALUE)
        if (currentFreq == Int.MIN_VALUE || currentFreq == 0) {
            continue
        }
        hashMap[num] = currentFreq - 1
        array.add(num)
    }
    return array.toIntArray()
}

fun main() {
    val array = intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    for (num in array) {
        println(num)
    }

}