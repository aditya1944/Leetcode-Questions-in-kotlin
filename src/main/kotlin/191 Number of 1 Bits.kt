fun hammingWeight(n:Int):Int{
    var count = 0
    var num = n
    while(num!=0){
        ++count
        num = num and (num-1)
    }
    return count
}

fun main(){
    println(hammingWeight(11))
}