fun firstBadVersion(n: Int): Int {
    var left = 0
    var right = n
    var firstBadVersion = n
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (isBadVersion(mid)) {
            //current version is bad
            firstBadVersion = mid
            right = mid - 1
        } else {
            //current version is good
            left = mid + 1
        }
    }
    return firstBadVersion
}

const val firstBadVersion = 1

fun main() {
    print(firstBadVersion(5))
}

fun isBadVersion(version: Int): Boolean {
    if (version >= firstBadVersion) {
        return true
    }
    return false
}