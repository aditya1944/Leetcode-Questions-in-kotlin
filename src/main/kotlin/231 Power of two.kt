fun isPowerofTwo(n: Int): Boolean{
    //number of set bit = 1
    if(n<=0){
        return false
    }
    if((n and (n-1))==0){
        return true
    }
    return false
}

fun main(){
    println(isPowerofTwo(-1024))
}