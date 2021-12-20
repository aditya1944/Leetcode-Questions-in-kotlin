fun singleNumber(nums: IntArray):Int{
    var x = 0
    for(num in nums){
        x = x xor num
    }
    return x
}