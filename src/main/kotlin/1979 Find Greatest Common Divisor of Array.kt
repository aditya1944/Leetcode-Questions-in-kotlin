fun findGCD(nums: IntArray): Int{
    var smallestNumberInArray = Int.MAX_VALUE;
    var largestNumberInArray = Int.MIN_VALUE;
    for(num in nums){
        smallestNumberInArray = kotlin.math.min(num, smallestNumberInArray);
        largestNumberInArray = kotlin.math.max(num, largestNumberInArray);
    }
    return gcd(largestNumberInArray, smallestNumberInArray);
}

fun gcd(num1: Int, num2: Int): Int{
    if(num1%num2==0){
        return num2;
    }
    return gcd(num2, num1%num2)
}