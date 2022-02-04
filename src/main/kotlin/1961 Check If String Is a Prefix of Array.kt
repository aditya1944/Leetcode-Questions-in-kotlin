fun isPrefixString(s: String, words: Array<String>): Boolean {
    var stringIndex = 0
    for (word in words) {

        for (index in word.indices) {
            if (word[index] != s[stringIndex]) {
                return false
            }
            ++stringIndex
            if (stringIndex == s.length) {
                //two conditions
                //1. in middle of string (bad case)
                //2. string is complete (good case)
                if (index == word.length - 1) {
                    return true
                }
                return false
            }
        }
    }
    return false
}


fun main() {
    print(isPrefixString("aaaaaaa", arrayOf("a", "a", "a", "a", "a", "a")))
}