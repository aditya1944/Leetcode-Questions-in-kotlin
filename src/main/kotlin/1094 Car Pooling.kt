fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val tempArray = ArrayList<IntArray>()
    trips.forEach {
        val arr1 = intArrayOf(it[1], it[0])
        val arr2 = intArrayOf(it[2], -it[0])
        tempArray.add(arr1)
        tempArray.add(arr2)
    }
    tempArray.sortWith(compareBy { it[0] })
    var currentCapacity = 0
    var index = 0
    while (index < tempArray.size) {
        var currentIntervalCapacity = 0
        var j = index
        while (j < tempArray.size && tempArray[j][0] == tempArray[index][0]) {
            currentIntervalCapacity += tempArray[j][1]
            ++j
        }
        currentCapacity += currentIntervalCapacity
        if (currentCapacity > capacity) {
            return false
        }
        index = j
    }
    return true
}

fun main() {
    //2 1 5, 3 3 7,  4
    println(carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 5))
}