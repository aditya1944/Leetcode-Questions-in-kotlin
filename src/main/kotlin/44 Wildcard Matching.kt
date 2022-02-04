fun isMatch(s: String, p: String): Boolean {
    val cache = Array(s.length) { Array(p.length) { -1 } }
    return helper(s, p, 0, 0, cache)
}

fun helper(s: String, p: String, sIndex: Int, pIndex: Int, cache: Array<Array<Int>>): Boolean {
    if (sIndex == s.length && pIndex == p.length) {
        return true
    }
    if (pIndex == p.length) {
        return false
    }
    if (sIndex == s.length) {
        if (p[pIndex] == '*') {
            return helper(s, p, sIndex, pIndex + 1, cache)
        }
        return false
    }

    if (cache[sIndex][pIndex] != -1) {
        return cache[sIndex][pIndex] == 1
    }

    if (p[pIndex] == '*') {
        val way1 = helper(s, p, sIndex + 1, pIndex, cache)
        val way2 = helper(s, p, sIndex + 1, pIndex + 1, cache)
        val way3 = helper(s, p, sIndex, pIndex + 1, cache)

        val result = way1 || way2 || way3

        cache[sIndex][pIndex] = if (result) {
            1
        } else {
            0
        }

        return result

    }
    val result = (s[sIndex] == p[pIndex] || p[pIndex] == '?') && helper(s, p, sIndex + 1, pIndex + 1, cache)
    cache[sIndex][pIndex] = if (result) {
        1
    } else {
        0
    }
    return result
}

fun main() {
    println(isMatch("aa", "*"))
}
