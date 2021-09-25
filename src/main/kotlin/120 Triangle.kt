// top down approach
fun minimumTotal(triangle: List<List<Int>>): Int{
    val cache = mutableMapOf<Pair<Int, Int>, Int>();
    return helper(triangle, 0, 0,cache)
}

fun helper(triangle: List<List<Int>>, currRow: Int, currCol: Int, cache: MutableMap<Pair<Int, Int>, Int>): Int{
    if(currRow==triangle.size){
        return 0
    }
    val cacheValue = cache[Pair(currRow, currCol)]
    if(cacheValue!=null){
        return cacheValue
    }
    val currValue = triangle[currRow][currCol]
    // go left and right
    val leftSum = helper(triangle, currRow+1, currCol, cache) + currValue;
    val rightSum = helper(triangle, currRow+1, currCol+1,cache) + currValue
    val solution = kotlin.math.min(leftSum, rightSum)
    cache[Pair(currRow, currCol)] = solution
    return solution
}

//bottom up approach
fun minimumTotal1(triangle: List<List<Int>>):Int{
    val cache = Array<Int>(triangle[triangle.size-1].size) {idx -> triangle[triangle.size-1][idx]}
    for(currRow in triangle.size-2 downTo 0){
        for(currCol in 0..currRow){
            cache[currCol] = kotlin.math.min(cache[currCol], cache[currCol+1]) + triangle[currRow][currCol]
        }
    }
    return cache[0];
}


fun main(){
    println(minimumTotal1(listOf(listOf(2), listOf(3,4), listOf(6,5,7), listOf(4,1,8,3))))
}