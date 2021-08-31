fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set = mutableSetOf<Int>();
    for(num in nums1){
        set.add(num);
    }
    val intersectionList = mutableListOf<Int>();

    for(num in nums2){
        if(set.contains(num)){
            intersectionList.add(num);
            set.remove(num)
        }
    }
    return intersectionList.toIntArray();
}

fun main(){
    val intersectionArray = intersection(intArrayOf(1,2,2,1), intArrayOf(2,2));
    for(num in intersectionArray){
        println(num);
    }
}