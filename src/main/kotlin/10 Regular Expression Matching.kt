class Solution20{
    fun isMatch(s: String, p: String): Boolean {
        val cache = Array(s.length) { Array(p.length) { -1 } }
        return helper(s, p, 0, 0, cache)
    }

    fun helper(s: String, p: String, sIndex: Int, pIndex: Int, cache: Array<Array<Int>>): Boolean {

        if (sIndex == s.length && pIndex == p.length) {
            return true
        }
        if (sIndex == s.length) {
            if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
                return helper(s, p, sIndex, pIndex + 2, cache)
            }
            return false
        }
        if (pIndex >= p.length) {
            return false
        }

        if (cache[sIndex][pIndex] != -1) {
            return cache[sIndex][pIndex] == 1
        }

        //if (p[pIndex] == '.' || s[sIndex] == p[pIndex]) {
        // current character of p and s is matching
        if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
            // three ways
            // either use the current character or not use
            // 1. use current s character

            val way1 = (s[sIndex] == p[pIndex] || p[pIndex] == '.') && helper(s, p, sIndex + 1, pIndex, cache)


            // 2. don't use current p character and skip forward
            val way2 = helper(s, p, sIndex, pIndex + 2, cache)


            // 3. use single occurrence in s and move forward
            val way3 = (s[sIndex] == p[pIndex] || p[pIndex] == '.') && helper(s, p, sIndex + 1, pIndex + 2, cache)

            val result = way1 || way2 || way3
            cache[sIndex][pIndex] = if (result) {
                1
            } else {
                0
            }
            return result
        }

        val result = (s[sIndex] == p[pIndex] || p[pIndex] == '.') && helper(s, p, sIndex + 1, pIndex + 1, cache)
        cache[sIndex][pIndex] = if (result) {
            1
        } else {
            0
        }

        return result

    }
}


fun main() {
    println(Solution20().isMatch("mississippi", "mis*is*p*"))
}
