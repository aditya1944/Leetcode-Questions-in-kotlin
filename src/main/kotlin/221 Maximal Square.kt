import kotlin.math.*

fun maximalSquare(matrix: Array<CharArray>): Int {
    val rows = matrix.size
    val cols = matrix[0].size
    val dp = Array(rows) { IntArray(cols) }
    var maxSquareArea = 0

    for (rowIndex in 0 until rows) {
        dp[rowIndex][0] = if (matrix[rowIndex][0] == '1') {
            maxSquareArea = 1
            1
        } else {
            0
        }
    }

    for (colIndex in 0 until cols) {
        dp[0][colIndex] = if (matrix[0][colIndex] == '1') {
            maxSquareArea = 1
            1
        } else {
            0
        }
    }



    for (rowIndex in 1 until rows) {
        for (colIndex in 1 until cols) {
            if (matrix[rowIndex][colIndex] == '0') {
                continue
            }
            dp[rowIndex][colIndex] =
                min(
                    dp[rowIndex - 1][colIndex],
                    min(dp[rowIndex][colIndex - 1], dp[rowIndex - 1][colIndex - 1])
                ) + 1
            maxSquareArea = max(dp[rowIndex][colIndex], maxSquareArea)
        }

    }
    return maxSquareArea
}

fun main() {
    val array = arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0')
    )
    println(maximalSquare(array))
}