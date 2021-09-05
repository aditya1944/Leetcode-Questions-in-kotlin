fun reverseWords(s: String): String {
    val arrayOfWords = s.split(" ");
    var returnValue = "";
    for(index in arrayOfWords.indices){
        returnValue += arrayOfWords[index].reversed();
        if(index != arrayOfWords.lastIndex){
            returnValue+=" ";
        }
    }
    return returnValue;
}


fun main(){
    print(reverseWords("God Ding"));
}