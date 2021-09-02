fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0;
    var right = nums.size-1;
    while(left+1<right){
        val mid = left + (right - left)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]<target){
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    if(target<=nums[left]){
        return left;
    }
    if(target<=nums[right]){
        return right;
    }
    return right+1;
}

fun main(){
    print(searchInsert(intArrayOf(1,3,5,6), 7))
}