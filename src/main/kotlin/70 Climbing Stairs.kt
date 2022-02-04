fun climbStairs(n: Int): Int {
    if (n == 1) {
        return 1
    }
    if (n == 2) {
        return 2
    }
    var prev2 = 1
    var prev1 = 2
    var current = 0

    for (step in 3..n) {
        current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    }

    return current
}


fun main() {
    println(climbStairs(3))
}