fun generate(numRows: Int): List<List<Int>> {
    var pascalTriangle = mutableListOf<MutableList<Int>>()
    if (numRows == 1) {
        pascalTriangle.add(mutableListOf(1))
        return pascalTriangle
    }
    if (numRows == 2) {
        pascalTriangle.add(mutableListOf(1))
        pascalTriangle.add(mutableListOf(1, 1))
        return pascalTriangle
    }
    pascalTriangle.add(mutableListOf(1))
    pascalTriangle.add(mutableListOf(1, 1))
    for (i in 2 until numRows) {
        pascalTriangle.add(mutableListOf(1))
        for (j in 1 until i) {
            pascalTriangle[i].add(pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j])
        }
        pascalTriangle[i].add(1)
    }
    return pascalTriangle
}

fun main() {
    println(generate(5))
}