import java.util.*

fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    val rows = matrix.size
    val cols = matrix[0].size
    val dp = Array(rows) { Array(cols) { -1 } }
    var maxPath = 0
    for (rowIndex in 0 until rows) {
        for (colIndex in 0 until cols) {

            maxPath = Math.max(dfs(matrix, rowIndex, colIndex, dp), maxPath)
        }
    }
    
    return maxPath
}

fun dfs(matrix: Array<IntArray>, startRow: Int, startCol: Int, dp: Array<Array<Int>>): Int {
    if (dp[startRow][startCol] != -1) {
        return dp[startRow][startCol]
    }
    //println("$startRow $startCol")

    var maxPath = 1

    if (startRow + 1 < matrix.size && matrix[startRow + 1][startCol] > matrix[startRow][startCol])
        maxPath = Math.max(maxPath, dfs(matrix, startRow + 1, startCol, dp) + 1)

    if (startRow - 1 > -1 && matrix[startRow - 1][startCol] > matrix[startRow][startCol])
        maxPath = Math.max(maxPath, dfs(matrix, startRow - 1, startCol, dp) + 1)

    if (startCol - 1 > -1 && matrix[startRow][startCol - 1] > matrix[startRow][startCol])
        maxPath = Math.max(maxPath, dfs(matrix, startRow, startCol - 1, dp) + 1)

    if (startCol + 1 < matrix[0].size && matrix[startRow][startCol + 1] > matrix[startRow][startCol])
        maxPath = Math.max(maxPath, dfs(matrix, startRow, startCol + 1, dp) + 1)

    dp[startRow][startCol] = maxPath
    //println("$startRow $startCol $maxPath")
    return maxPath
}