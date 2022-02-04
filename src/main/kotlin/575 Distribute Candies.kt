fun distributeCandies(candyType: IntArray): Int {
    val set = HashSet<Int>()


    for (num in candyType) {
        set.add(num)
    }

    return kotlin.math.min(set.size, candyType.size / 2)
}

fun main() {
    print(distributeCandies(intArrayOf(1, 1, 2, 3)))
}