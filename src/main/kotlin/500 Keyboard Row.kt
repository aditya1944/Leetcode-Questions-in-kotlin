fun findWords(words: Array<String>): Array<String> {
    val firstRowSet = setOf<Char>('q','w','e','r','t','y','u','i','o','p');
    val secondRowSet = setOf<Char>('a','s','d','f','g','h','j','k','l');
    val thirdRowSet = setOf<Char>('z','x','c','v','b','n','m');

    val returnArray = mutableListOf<String>();
    for(currentWord in words){
        val word = currentWord.lowercase();
        var currentSet = if(firstRowSet.contains(word[0])){
            firstRowSet;
        }else if(secondRowSet.contains(word[0])){
            secondRowSet;
        }else{
            thirdRowSet;
        }
        if(wordInSameSet(currentSet, word)){
            returnArray.add(currentWord);
        }
    }
    return returnArray.toTypedArray();
}

fun wordInSameSet(set: Set<Char>, word: String): Boolean{
    for(char in word){
        if(!set.contains(char)){
            return false;
        }
    }
    return true;
}

fun main(){
    val arrayOfString = findWords(arrayOf("hello", "alaska","Dad", "Peace"));
    for(string in arrayOfString){
        println(string);
    }
}