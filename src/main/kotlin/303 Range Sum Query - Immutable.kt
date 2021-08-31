class NumArray(nums: IntArray) {
    private val _nums = nums;
    private val prefixSum: Array<Int> = Array<Int>(nums.size){0};

    init {
        for(index in nums.indices){
            if(index==0){
                prefixSum[index] = nums[index];
            }else{
                prefixSum[index] = prefixSum[index-1] + nums[index];
            }
        }
    }



    fun sumRange(left: Int, right: Int): Int {
        if(left==right){
            return _nums[left];
        }
        if(left==0){
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left-1];
    }

}

fun main(){
    val findRangeSum = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1));
    print(findRangeSum.sumRange(0,2));
    print(findRangeSum.sumRange(2,5));
    print(findRangeSum.sumRange(0, 5));
}