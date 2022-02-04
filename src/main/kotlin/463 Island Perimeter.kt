fun islandPerimeter(grid: Array<IntArray>): Int {
    //check all 4 sides for water
    var perimeter = 0
    for (rowIndex in grid.indices) {
        for (colIndex in grid[rowIndex].indices) {
            if (grid[rowIndex][colIndex] == 1) {
                //this is land
                val currentPerimeter = findPerimeter(grid, rowIndex, colIndex)
                perimeter += currentPerimeter
            }
        }
    }
    return perimeter
}

fun findPerimeter(grid: Array<IntArray>, rowIndex: Int, colIndex: Int): Int {
    //check left
    var perimeter = 0
    if (colIndex - 1 < 0 || grid[rowIndex][colIndex - 1] == 0) {
        perimeter += 1
    }
    //check right
    if (colIndex + 1 >= grid[rowIndex].size || grid[rowIndex][colIndex + 1] == 0) {
        perimeter += 1
    }
    //check up
    if (rowIndex - 1 < 0 || grid[rowIndex - 1][colIndex] == 0) {
        perimeter += 1
    }
    //check down
    if (rowIndex + 1 >= grid.size || grid[rowIndex + 1][colIndex] == 0) {
        perimeter += 1
    }
    return perimeter
}


fun main() {
    val grid: Array<IntArray> =
        arrayOf(intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 1, 0), intArrayOf(0, 1, 0, 0), intArrayOf(1, 1, 0, 0))
    print(islandPerimeter(grid))
}