import java.util.*

fun findAnagrams(s: String, p: String): List<Int> {
    val returnValue = LinkedList<Int>()
    if (p.length > s.length) {
        return returnValue
    }
    val windowMap = Array(26) { 0 }
    for (char in p) {
        ++windowMap[char - 'a']
    }

    var startIndex = 0
    var endIndex = 0

    var matchedChar = 0
    while (endIndex < p.length) {
        windowMap[s[endIndex] - 'a'] -= 1

        if (windowMap[s[endIndex] - 'a'] >= 0) {
            ++matchedChar
        }
        ++endIndex
    }

    if (matchedChar == p.length) {
        returnValue.add(0)
    }

    while (endIndex < s.length) {
        windowMap[s[startIndex] - 'a'] += 1

        if (windowMap[s[startIndex] - 'a'] > 0) {
            --matchedChar
        }

        ++startIndex

        windowMap[s[endIndex] - 'a'] -= 1

        if (windowMap[s[endIndex] - 'a'] >= 0) {
            ++matchedChar
        }

        if (matchedChar == p.length) {
            returnValue.add(startIndex)
        }

        ++endIndex
    }

    return returnValue
}

fun main() {
    val list = findAnagrams("cadbcbacbabacd", "abc")

    for (char in list) {
        println(char)
    }
}