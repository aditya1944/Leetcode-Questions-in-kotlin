fun sortedSquares(nums: IntArray): IntArray {
    var left = 0
    var right = nums.size-1;
    val sortedSquareArray = IntArray(nums.size);
    var currentIndex = nums.size-1;
    while(left<=right){
        if(nums[left]*nums[left]<=nums[right]*nums[right]){
            sortedSquareArray[currentIndex] = nums[right]*nums[right];
            --right;
        }else{
            sortedSquareArray[currentIndex] = nums[left]*nums[left];
            ++left;
        }
        --currentIndex;
    }
    return sortedSquareArray;
}


fun main(){
    val array = sortedSquares(intArrayOf(-7,-3,2,3,11));
    for(num in array){
        println(num);
    }
}