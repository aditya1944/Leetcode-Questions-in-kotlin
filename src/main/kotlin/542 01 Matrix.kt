fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val distanceMatrix = Array<IntArray>(mat.size) { IntArray(mat[0].size) { mat[0].size + mat.size } }
    for (rowIndex in mat.indices) {
        for (colIndex in mat[rowIndex].indices) {
            //find the nearest distance for cell having value = 1;
            if (mat[rowIndex][colIndex] == 1) {
                if (rowIndex - 1 >= 0) {
                    distanceMatrix[rowIndex][colIndex] = distanceMatrix[rowIndex - 1][colIndex] + 1
                }
                if (colIndex - 1 >= 0) {
                    distanceMatrix[rowIndex][colIndex] =
                        kotlin.math.min(distanceMatrix[rowIndex][colIndex - 1] + 1, distanceMatrix[rowIndex][colIndex])
                }
            } else {
                distanceMatrix[rowIndex][colIndex] = 0
            }
        }
    }

    for (rowIndex in mat.size - 1 downTo 0) {
        for (colIndex in mat[rowIndex].size - 1 downTo 0) {
            //find the nearest distance for cell having value = 1;
            if (mat[rowIndex][colIndex] == 1) {
                if (rowIndex + 1 < mat.size) {
                    distanceMatrix[rowIndex][colIndex] =
                        kotlin.math.min(distanceMatrix[rowIndex + 1][colIndex] + 1, distanceMatrix[rowIndex][colIndex])
                }
                if (colIndex + 1 < mat[rowIndex].size) {
                    distanceMatrix[rowIndex][colIndex] =
                        kotlin.math.min(distanceMatrix[rowIndex][colIndex + 1] + 1, distanceMatrix[rowIndex][colIndex])
                }
            }
        }
    }

    return distanceMatrix
}

fun main() {
    val matrix = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(1, 1, 0))
    val distanceArray = updateMatrix(matrix)
    for (distanceRow in distanceArray) {
        for (distance in distanceRow) {
            print(distance)
        }
        println()
    }
}