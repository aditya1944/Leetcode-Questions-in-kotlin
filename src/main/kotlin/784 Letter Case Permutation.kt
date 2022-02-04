fun letterCasePermutation(s: String): List<String> {
    val returnList = mutableListOf<String>()
    val stringBuilder = StringBuilder(s)
    helper(stringBuilder, 0, returnList)
    return returnList
}

fun helper(stringBuilder: StringBuilder, currIndex: Int, returnList: MutableList<String>) {
    returnList.add(stringBuilder.toString())
    if (currIndex == stringBuilder.length) {
        return
    }

    for (index in currIndex until stringBuilder.length) {
        if (stringBuilder[index].isDigit()) {
            continue
        }
        stringBuilder[index] = change(stringBuilder[index])
        helper(stringBuilder, index + 1, returnList)
        stringBuilder[index] = change(stringBuilder[index])
    }

}

fun change(ch: Char): Char {
    if (ch.isLowerCase()) {
        return ch - 32
    }
    return ch + 32
}

fun main() {
    val list = letterCasePermutation("a1b2")
    for (string in list) {
        println(string)
    }
}