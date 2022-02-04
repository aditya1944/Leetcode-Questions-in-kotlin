fun combine(n: Int, k: Int): List<List<Int>> {
    val returnList = mutableListOf<List<Int>>()
    for (startingNum in n downTo 1) {
        val list = mutableListOf<Int>()
        list.add(startingNum)
        helper(startingNum - 1, k - 1, list, returnList)
    }
    return returnList
}

fun helper(startingNum: Int, kLeft: Int, currentList: MutableList<Int>, returnList: MutableList<List<Int>>) {
    if (kLeft == 0) {
        val cloneList = currentList.toMutableList()
        returnList.add(cloneList)
        return
    }
    for (num in startingNum downTo 1) {
        currentList.add(num)
        helper(num - 1, kLeft - 1, currentList, returnList)
        currentList.removeLast()
    }
    return
}

fun main() {
    val list = combine(3, 3)
    for (subList in list) {
        for (num in subList) {
            print(num)
        }
        println()
    }
}