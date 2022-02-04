fun longestSubstring(s: String, k: Int): Int {
    return check(s, 0, s.length - 1, k)
}

fun check(s: String, startIndex: Int, endIndex: Int, k: Int): Int {
    if (startIndex > endIndex) {
        return 0
    }

    val freqCount = Array(26) { 0 }
    for (index in startIndex..endIndex) {
        freqCount[s[index] - 'a'] += 1
    }

    for (index in startIndex..endIndex) {
        if (freqCount[s[index] - 'a'] < k) {
            // do partition from here
            return kotlin.math.max(check(s, startIndex, index - 1, k), check(s, index + 1, endIndex, k))
        }
    }

    return endIndex - startIndex + 1

}

fun main() {
    //k = 3
    //aaabbccddeeffgghhii
    //aaa
    println(longestSubstring("bbaaacb", 3))
}