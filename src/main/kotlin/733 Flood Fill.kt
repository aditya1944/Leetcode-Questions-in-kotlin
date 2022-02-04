fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    if (newColor == image[sr][sc]) {
        return image
    }
    val oldColor = image[sr][sc]
    helper(image, sr, sc, oldColor, newColor)
    return image
}

fun helper(image: Array<IntArray>, currentRow: Int, currentCol: Int, oldColor: Int, newColor: Int) {
    image[currentRow][currentCol] = newColor
    // traverse all the neighbour

    val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))

    for (dir in dirs) {
        val newRowIndex = dir[0] + currentRow
        val newColIndex = dir[1] + currentCol
        if (newRowIndex >= 0 && newColIndex >= 0 && newRowIndex < image.size && newColIndex < image[0].size && image[newRowIndex][newColIndex] == oldColor) {
            helper(image, newRowIndex, newColIndex, oldColor, newColor)
        }
    }
}

fun main() {
    val array = floodFill(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1)), 1, 1, 2)
    for (row in array) {
        for (color in row) {
            print(color)
        }
        println()
    }
}