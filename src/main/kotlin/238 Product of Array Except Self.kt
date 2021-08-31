fun productExceptSelf(nums: IntArray): IntArray {
    val productArray = IntArray(nums.size);
    productArray[0] = 1;
    for(index in 1 until nums.size){
        productArray[index] = nums[index-1]*productArray[index-1];
    }
    var multiplier = 1;
    for(index in nums.size-2 downTo 0){
        productArray[index] *= (nums[index+1] * multiplier)
        multiplier*=nums[index+1]
    }
    return productArray
}

// two array approach

fun productExceptSelf2(nums: IntArray): IntArray{
    val leftProductArray = IntArray(nums.size);
    val rightProductArray = IntArray(nums.size);
    val productArray = IntArray(nums.size);
    //populate leftProductArray and rightProductArray
    leftProductArray[0] = 1;
    for(index in 1 until nums.size){
        leftProductArray[index] = leftProductArray[index-1]* nums[index-1];
    }
    rightProductArray[rightProductArray.size-1] = 1;
    for(index in nums.size-2 downTo 0){
        rightProductArray[index] = rightProductArray[index+1] * nums[index+1];
    }
    for(index in productArray.indices){
        if(index==0){
            productArray[index] = rightProductArray[0];
        }else if(index == productArray.lastIndex){
            productArray[index] = leftProductArray[leftProductArray.size-1];
        }else {
            productArray[index] = leftProductArray[index] * rightProductArray[index];
        }
    }
    return productArray;
}


fun main(){
    val productArray = productExceptSelf(intArrayOf(1,2,3,4));
    val productArray2 = productExceptSelf2(intArrayOf(1,2,3,4));
    for(num in productArray){
        println(num);
    }
    println("New");
    for(num in productArray2){
        println(num);
    }
}