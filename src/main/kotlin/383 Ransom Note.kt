fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val map = HashMap<Char, Int>()
    for(char in magazine){
        val frequencyOfChar = map.getOrDefault(char, 0)
        map[char] = frequencyOfChar + 1
    }
    for(char in ransomNote){
        val frequencyOfCharInMagazine = map.getOrDefault(char, 0)
        if(frequencyOfCharInMagazine==0){
            return false
        }
        map[char] = frequencyOfCharInMagazine - 1
    }
    return true
}