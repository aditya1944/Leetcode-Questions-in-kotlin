fun arrayPairSum(nums: IntArray): Int {
    nums.sort();
    var sum = 0;
    for(index in nums.indices step 2){
        sum+=kotlin.math.min(nums[index] , nums[index+1]);
    }
    return sum;
}


fun main(){
    print(arrayPairSum(intArrayOf(1,2,3,4,5)));
}