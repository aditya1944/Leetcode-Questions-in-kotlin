fun search(nums: IntArray, target: Int): Int {
    var left = 0;
    var right = nums.size-1;
    while(left<=right){
        val mid = left + (right - left)/2;
        if(nums[mid]==target){
            return mid;
        }else if(target>nums[mid]){
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    return -1;
}

fun main(){
    print(search(intArrayOf(2),2));
}