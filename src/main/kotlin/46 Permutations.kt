fun permute(nums: IntArray): List<List<Int>> {
    val returnList = mutableListOf<MutableList<Int>>()
    helper(nums, returnList, 0)
    return returnList
}

fun helper(nums: IntArray, returnList: MutableList<MutableList<Int>>, swapIndex: Int) {

    if (swapIndex == nums.size) {
        val currentList = nums.toMutableList()
        returnList.add(currentList)
        return
    }

    for (index in swapIndex until nums.size) {

        swap(nums, index, swapIndex)

        helper(nums, returnList, swapIndex + 1)

        swap(nums, index, swapIndex)
    }
}

fun swap(array: IntArray, index1: Int, index2: Int) {
    val temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp
}

fun main() {
    val permutationList = permute(intArrayOf(1, 2, 3))
    for (permutation in permutationList) {
        for (num in permutation) {
            print(num)
        }
        println()
    }
}