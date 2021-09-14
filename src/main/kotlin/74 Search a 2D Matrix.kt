import kotlin.math.sign

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    //do column wise binary search
    // do row wise binary search
    val row = rowBinarySearch(matrix, target);
    if(row==matrix.size){
        return false;
    }
    return colBinarySearch(matrix, row, target)
}

fun colBinarySearch(matrix: Array<IntArray>, row: Int,target: Int): Boolean{
    var left = 0
    var right = matrix[row].size-1;
    while(left<=right){
        val mid = left + (right - left)/2;
        if(target==matrix[row][mid]){
            return true;
        }else if(target<matrix[row][mid]){
            right = mid-1;
        }else{
            left = mid+1;
        }
    }
    return false;
}


fun rowBinarySearch(matrix: Array<IntArray>, target: Int): Int{
    var left = 0;
    var right = matrix.size-1;
    val lastColumnIndex = matrix[0].size-1;
    while(left+1<right){
        val mid = left + (right - left)/2;
        if(matrix[mid][lastColumnIndex]==target){
            return mid;
        }else if(matrix[mid][lastColumnIndex]<target){
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    if(target<=matrix[left][lastColumnIndex]){
        return left;
    }
    if(target>matrix[left][lastColumnIndex] && target<=matrix[right][lastColumnIndex]){
        return right;
    }
    return right+1;
}


fun main(){
    print(searchMatrix(arrayOf(intArrayOf(1), intArrayOf(3)), 3));
}