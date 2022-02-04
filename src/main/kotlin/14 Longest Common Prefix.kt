fun longestCommonPrefix(strs: Array<String>): String {
    var prefixArray = strs[0].toMutableList()
    for (index in 1 until strs.size) {
        helper(strs[index], prefixArray)
    }
    return prefixArray.joinToString("")
}

fun helper(str: String, prefixArray: MutableList<Char>) {
    while (prefixArray.size > str.length) {
        prefixArray.removeAt(prefixArray.lastIndex)
    }
    var indexBreak = -1
    val minIndex = if (prefixArray.size < str.length) {
        prefixArray.lastIndex
    } else {
        str.lastIndex
    }
    for (index in 0..minIndex) {

        if (str[index] != prefixArray[index]) {
            indexBreak = index
            break
        }
    }
    if (indexBreak != -1) {
        // have to remove suffix
        var count = prefixArray.size - indexBreak
        while (count > 0) {
            prefixArray.removeAt(prefixArray.lastIndex)
            count -= 1
        }
    }
}

fun main() {
    val stringArray = arrayOf("dog", "racecar", "car")
    val commonPrefix = longestCommonPrefix(stringArray)
    println(commonPrefix)
}