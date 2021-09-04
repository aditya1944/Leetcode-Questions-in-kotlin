class Solution1{
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>();
        for(index in nums.indices){
            val requiredNumInMap = target - nums[index];
            val indexOfRequiredNum = map[requiredNumInMap];
            if(indexOfRequiredNum!=null){
                // we found the pair
                return intArrayOf(index, indexOfRequiredNum);
            }else{
                map[nums[index]] = index;
            }
        }
        return intArrayOf(-1,-1);
    }
}

fun main(){
    val array = Solution1().twoSum(intArrayOf(3,3), 6);
    for(num in array){
        print(num);
    }
}