fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    var left = 0
    var right = 0
    val windowSet = HashSet<Char>()
    var maxLength = 1
    while (right < s.length) {
        val currentChar = s[right]
        if (windowSet.contains(currentChar)) {
            //there is a repetition
            while (s[left] != currentChar) {
                windowSet.remove(s[left])
                ++left
            }
            // s is now at current char
            ++left
        }
        windowSet.add(currentChar)
        maxLength = kotlin.math.max(maxLength, right - left + 1)
        ++right
    }
    return maxLength
}

fun main() {
    print(lengthOfLongestSubstring("abbabcbe"))
}