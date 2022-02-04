fun summaryRanges(nums: IntArray): List<String> {
    var list = mutableListOf<String>()
    if (nums.isEmpty()) {
        return list
    }
    var currentRangeStart = nums[0]
    var currentRangeEnd = nums[0]
    for (index in 0 until nums.size - 1) {
        if (nums[index] + 1 == nums[index + 1]) {
            currentRangeEnd = nums[index + 1]
        } else {
            if (currentRangeStart != currentRangeEnd)
                list.add("$currentRangeStart->$currentRangeEnd")
            else
                list.add(currentRangeStart.toString())
            currentRangeStart = nums[index + 1]
            currentRangeEnd = nums[index + 1]
        }
    }
    if (currentRangeStart != currentRangeEnd)
        list.add("$currentRangeStart->$currentRangeEnd")
    else
        list.add(currentRangeStart.toString())
    return list
}

fun main() {
    print(summaryRanges(intArrayOf(-1)))
}