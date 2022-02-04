fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rowMap = HashMap<Int, HashSet<Char>>()
    val colMap = HashMap<Int, HashSet<Char>>()

    for (rowIndex in board.indices) {
        for (colIndex in board[rowIndex].indices) {
            val currentChar = board[rowIndex][colIndex]
            if (currentChar == '.') {
                continue
            }
            val setOfNumInRow = rowMap[rowIndex]
            if (setOfNumInRow != null && setOfNumInRow.contains(currentChar)) {
                return false
            }
            if (setOfNumInRow == null) {
                rowMap[rowIndex] = HashSet<Char>()
            }

            rowMap[rowIndex]?.add(currentChar)

            val setOfNumInCol = colMap[colIndex]
            if (setOfNumInCol != null && setOfNumInCol.contains(currentChar)) {
                return false
            }

            if (setOfNumInCol == null) {
                colMap[colIndex] = HashSet<Char>()
            }

            colMap[colIndex]?.add(currentChar)

            //check in trident
            if (tridentCheck(board, rowIndex, colIndex)) {
                return false
            }
        }
    }

    return true
}

fun tridentCheck(board: Array<CharArray>, rowIndex: Int, colIndex: Int): Boolean {
    val currentRow = if (rowIndex < 3) 0 else if (rowIndex < 6) 3 else 6
    val currentCol = if (colIndex < 3) 0 else if (colIndex < 6) 3 else 6

    for (rowOffset in 0..2) {
        for (colOffset in 0..2) {
            if (currentRow + rowOffset == rowIndex && currentCol + colOffset == colIndex) {
                continue
            }
            if (board[currentRow + rowOffset][currentCol + colOffset] == board[rowIndex][colIndex]) {
                return true
            }
        }
    }
    return false
}