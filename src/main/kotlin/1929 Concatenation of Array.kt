fun getConcatenation(nums: IntArray): IntArray {
    val returnArray = IntArray(nums.size*2);
    for(index in nums.indices){
        returnArray[index] = nums[index];
        returnArray[nums.size+index] = nums[index];
    }
    return returnArray;
}


fun main(){
    val array = getConcatenation(intArrayOf(1,2,1));
    for(num in array){
        print(num);
    }
}