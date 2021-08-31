fun missingNumber(nums: IntArray): Int{
    var sum = nums.sum();
    var totalRequired = (nums.size*(nums.size+1))/2
    return totalRequired - sum;
}

fun main(){
    print(missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)))
}