fun numIslands(grid: Array<CharArray>): Int {
    val visited = Array(grid.size) { Array(grid.size) { false } }

    var largestIsland = 0

    for (rowIndex in grid.indices) {
        for (colIndex in grid[rowIndex].indices) {
            if (grid[rowIndex][colIndex] == '1') {
                largestIsland = dfs(grid, rowIndex, colIndex, visited).coerceAtLeast(largestIsland)
            }
        }
    }
    return largestIsland;
}

fun dfs(grid: Array<CharArray>, rowIndex: Int, colIndex: Int, visited: Array<Array<Boolean>>): Int {
    if (visited[rowIndex][colIndex]) {
        return 0
    }

    visited[rowIndex][colIndex] = true

    var totalIslands = 1

    val rightSide = grid[rowIndex].getOrNull(colIndex + 1)
    if (rightSide != null && rightSide == '1') {
        totalIslands += dfs(grid, rowIndex, colIndex + 1, visited)
    }
    val leftSide = grid[rowIndex].getOrNull(colIndex - 1)
    if (leftSide != null && leftSide == '1') {
        totalIslands += dfs(grid, rowIndex, colIndex - 1, visited)
    }

    val upSide = grid.getOrNull(rowIndex - 1)?.getOrNull(colIndex)
    if (upSide != null && upSide == '1') {
        totalIslands += dfs(grid, rowIndex - 1, colIndex, visited)
    }
    val downSide = grid.getOrNull(rowIndex + 1)?.getOrNull(colIndex)
    if (downSide != null && downSide == '1') {
        totalIslands += dfs(grid, rowIndex + 1, colIndex, visited)
    }
    return totalIslands;
}
