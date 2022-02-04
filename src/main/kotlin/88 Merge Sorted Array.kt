fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1
    var j = n - 1
    var k = nums1.size - 1
    while (i >= 0 && j >= 0) {
        if (nums1[i] >= nums2[j]) {
            nums1[k] = nums1[i]
            --i
        } else {
            nums1[k] = nums2[j]
            --j
        }
        --k
    }
    while (i >= 0) {
        nums1[k] = nums1[i]
        --i
    }
    while (j >= 0) {
        nums1[k] = nums2[j]
        --j
    }
}


fun main() {
    val array = intArrayOf(1, 2, 3, 0, 0, 0)
    merge(array, 3, intArrayOf(2, 5, 6), 3)
    for (num in array) {
        println(num)
    }
}