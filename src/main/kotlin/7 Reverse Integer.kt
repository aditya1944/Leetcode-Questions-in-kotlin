

fun reverse(x: Int): Int{
    var digit = x;
    var reversedDigit = 0;
    while(digit!=0){
        var currentDigit = digit%10;
        if(reversedDigit>Int.MAX_VALUE/10 || (reversedDigit==Int.MAX_VALUE/10 && currentDigit>7)){
            return 0;
        }
        if(reversedDigit<Int.MIN_VALUE/10 || (reversedDigit==Int.MIN_VALUE/10 && currentDigit<-8)){
            return 0;
        }
        reversedDigit = (reversedDigit*10) + currentDigit;
        digit /= 10;
    }
    return reversedDigit;
}

fun main(){
    print(reverse(-214748364))
}