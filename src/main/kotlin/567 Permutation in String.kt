fun checkInclusion(s1: String, s2: String): Boolean {
    if(s1.length>s2.length){
        return false;
    }
    val s1Map = HashMap<Char, Int>();
    val windowMap = HashMap<Char, Int>();
    for(ch in s1){
        val countOfCh = s1Map.getOrDefault(ch, 0);
        s1Map[ch] = countOfCh+1;
    }
    var left = 0;
    var right = 0;
    while(right<s2.length){
        if(s1Map.containsKey(s2[right])){
            val countOfCharacterInWindowMap = windowMap.getOrDefault(s2[right], 0);
            windowMap[s2[right]] = countOfCharacterInWindowMap + 1
            if(windowMap.size == s1Map.size && windowMap == s1Map){
                return true;
            }
            if(s1.length == right - left + 1){
                // we have reached s1 size window
                val frequencyOfLeftChar = windowMap.getOrDefault(s2[left], 0);
                windowMap[s2[left]] = frequencyOfLeftChar - 1;
                ++left;
            }
        }else{
            left = right+1;
            windowMap.clear()
        }
        ++right;
    }
    return false;
}



fun main(){
    print(checkInclusion("2b", "abcd"));
}