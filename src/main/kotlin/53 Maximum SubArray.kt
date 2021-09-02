
fun maxSubArray(nums: IntArray): Int {
    var globalMax:Long = Int.MIN_VALUE.toLong();
    var currentMax:Long = Int.MIN_VALUE.toLong();
    for(num in nums){
        currentMax = kotlin.math.max(num.toLong(), currentMax+num);
        globalMax = kotlin.math.max(globalMax, currentMax);
    }
    return globalMax.toInt();
}



fun main(){
    print(maxSubArray(intArrayOf(5,4,-1,7,8)));
}