fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    var map = HashMap<Int, Int>();
    for(index in 0 until k)   {
        if(map.containsKey(nums[index])){
            return true;
        }
        map[nums[index]] = index;
    }
    var left = 0;
    var right = k-1;
    while(right<nums.size-1){
        ++right;
        if(map.containsKey(nums[right])){
            return true;
        }else{
            map[nums[right]] = right;
            map.remove(nums[left]);
            ++left;
        }
    }
    return false;
}

fun main(){
    print(containsNearbyDuplicate(intArrayOf(1,0,1,1), 1));
}