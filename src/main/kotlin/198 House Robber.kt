fun rob(nums: IntArray): Int {
    val cache = mutableMapOf<Int, Int>()
    return helper(0, nums, cache)
}

fun helper(currentIndex: Int, nums: IntArray, cache: MutableMap<Int, Int>): Int{
    var totalAmount = 0;
    if(currentIndex>=nums.size){
        return totalAmount
    }
    val cacheValueForCurrentIndex = cache[currentIndex]
    if(cacheValueForCurrentIndex!=null){
        return cacheValueForCurrentIndex
    }
    totalAmount = kotlin.math.max(helper(currentIndex+1, nums, cache), helper(currentIndex+2, nums, cache)+nums[currentIndex])
    return totalAmount
}

fun main(){
    println(rob(intArrayOf(2,7,9,3,1)))
}