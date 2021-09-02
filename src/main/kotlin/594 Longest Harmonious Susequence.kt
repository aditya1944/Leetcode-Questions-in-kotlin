fun findLHS(nums: IntArray): Int{
    val map = HashMap<Int, Int>();
    val array = mutableListOf<Int>();
    var maxCount = 0;
    for(num in nums){
        map[num] = map.getOrDefault(num,0) + 1;
        array.add(num);
    }
    for(num in array){
        if(map.containsKey(num+1))
            maxCount = kotlin.math.max(maxCount, map.getOrDefault(num, 0) + map.getOrDefault(num+1, 0));
    }
    return maxCount;
}

fun main(){
    print(findLHS(intArrayOf(1,3,2,2,5,2,3,7)));
}