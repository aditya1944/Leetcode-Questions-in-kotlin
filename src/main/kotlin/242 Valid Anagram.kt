fun isAnagram(s:String, t:String): Boolean{
    if(s.length!=t.length){
        return false
    }
    val hashMap = HashMap<Char, Int>();
    for(char in s){
        val count = hashMap.getOrDefault(char, 0);
        hashMap[char] = count+1;
    }
    var countOfChar  = 0;
    for(char in t){
        if(!hashMap.containsKey(char)){
            return false;
        }
        val count = hashMap[char];
        if(count==null){
            return false;
        }else{
            if(count==0){
                return false;
            }
            hashMap[char] = count - 1;
        }
    }
    return true;
}

fun main(){

}