fun reverseBits(n:Int): Int{
    var returnValue = 0
    var bitIndex = 0
    while(bitIndex<32){
        returnValue = returnValue shl 1
        if(n and (1 shl bitIndex)!=0){
            //current bit is 1
            returnValue = returnValue or 1
        }
        ++bitIndex
    }
    return returnValue
}

fun main(){
    print(reverseBits(1))
}