fun findContentChildren(g: IntArray, s: IntArray): Int {
    var numberOfContentChildren = 0
    var greedArray = g
    var cookieArray = s
    greedArray.sort()
    cookieArray.sort()
    var cookieIndex = 0
    var greedIndex = 0
    while (cookieIndex < cookieArray.size && greedIndex < greedArray.size) {
        if (cookieArray[cookieIndex] >= greedArray[greedIndex]) {
            ++numberOfContentChildren
            ++greedIndex
        }
        ++cookieIndex
    }
    return numberOfContentChildren
}

fun main() {
    print(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}