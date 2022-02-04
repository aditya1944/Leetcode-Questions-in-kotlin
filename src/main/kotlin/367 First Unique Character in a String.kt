fun firstUniqChar(s: String): Int {

    val map = HashMap<Char, Int>()
    for (char in s) {
        val frequencyOfCurrentCharacter = map.getOrDefault(char, 0)
        map[char] = frequencyOfCurrentCharacter + 1
    }
    for (index in s.indices) {
        val frequencyOfCurrentChar = map[s[index]]
        if (frequencyOfCurrentChar != null && frequencyOfCurrentChar == 1) {
            return index
        }
    }

    return -1
}