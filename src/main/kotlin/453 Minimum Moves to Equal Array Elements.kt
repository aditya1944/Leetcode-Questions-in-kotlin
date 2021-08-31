fun minMoves(nums: IntArray): Int{
    val minArrayElement = nums.minOrNull() ?: return 0;
    //find deviation
    var deviation = 0;
    for(num in nums){
        deviation+=(num - minArrayElement);
    }
    return deviation;
}

fun main(){
    print(minMoves(intArrayOf(1,1,1)))
}