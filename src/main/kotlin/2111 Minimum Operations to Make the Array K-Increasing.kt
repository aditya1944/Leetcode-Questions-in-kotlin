fun kIncreasing(arr: IntArray, k: Int): Int {
    var startIndex = 0
    var ans = 0
    while (startIndex < k) { // O(k)
        val array = ArrayList<Int>()
        for (index in startIndex until arr.size step k) {// O(k) * (O(n) + O(n * log n))
            array.add(arr[index])
        }
        val lisLength = lis(array)
        ans += (array.size - lisLength)
        ++startIndex
    }
    return ans
}

private fun lis(array: ArrayList<Int>): Int {// O(nlogn)
    if (array.size == 0) {
        return 0
    }
    val lisArray = Array<Int>(array.size + 1) { Int.MAX_VALUE }
    lisArray[0] = Int.MIN_VALUE
    var longestLength = 0

    for (num in array) {
        var index = lisArray.binarySearch(num)
        // if index>=0 then num is at index ; in case of duplicates any index will be returned.
        // if index<0 then num is not present in that array; the index abs value returns the upperbound.
        if (index < 0) {
            index *= -1
            index -= 1
        } else {
            while (lisArray[index] == num) {
                ++index
            }
        }
        lisArray[index] = num
        longestLength = kotlin.math.max(longestLength, index)
    }
    return longestLength
}

fun main() {
    println(kIncreasing(intArrayOf(2, 2, 2, 2, 2, 1, 1, 4, 4, 3, 3, 3, 3, 3), 1))
}