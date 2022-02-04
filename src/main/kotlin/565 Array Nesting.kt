fun arrayNesting(nums: IntArray): Int {
    val indicesMap = HashMap<Int, Int>()//maintains a map of visited index with their count;
    //start from index 0;
    var max = 0
    for (index in nums.indices) {
        max = if (indicesMap.containsKey(index)) {
            kotlin.math.max(max, indicesMap.getOrDefault(index, 0))
        } else {
            val visitedSet = HashSet<Int>()
            kotlin.math.max(helper(nums, index, visitedSet, indicesMap), max)
        }
    }
    return max
}

fun helper(nums: IntArray, currIndex: Int, visitedSet: HashSet<Int>, indicesMap: HashMap<Int, Int>): Int {
    if (indicesMap.containsKey(currIndex)) {
        return indicesMap.getOrDefault(currIndex, 0)
    }
    if (visitedSet.contains(currIndex)) {
        return 0
    }
    visitedSet.add(currIndex)
    val currentSol = 1 + helper(nums, nums[currIndex], visitedSet, indicesMap)
    indicesMap[currIndex] = currentSol
    return currentSol
}

fun main() {
    print(arrayNesting(intArrayOf(5, 4, 0, 3, 1, 6, 2)))
}