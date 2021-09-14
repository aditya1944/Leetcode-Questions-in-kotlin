import java.util.*

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    val seenMatrix = Array<BooleanArray>(grid.size) { BooleanArray(grid[0].size) {false} }
    var maxArea = 0;
    for(rowIndex in grid.indices){
        for(colIndex in grid[rowIndex].indices){
            if(grid[rowIndex][colIndex]==1 && !seenMatrix[rowIndex][colIndex]){
                maxArea = kotlin.math.max(maxArea, dfs(grid, rowIndex, colIndex, seenMatrix));
            }
        }
    }
    return maxArea
}

fun dfs(grid: Array<IntArray>, rowIndex: Int, colIndex: Int, seen: Array<BooleanArray>): Int{
    var area = 0;
    val stack = Stack<Pair<Int, Int>>();
    stack.push(Pair(rowIndex, colIndex));
    seen[rowIndex][colIndex] = true;
    val dirs = arrayOf(intArrayOf(-1,0), intArrayOf(0,-1), intArrayOf(1,0), intArrayOf(0,1))
    while(stack.isNotEmpty()){
        val top = stack.pop();
        seen[top.first][top.second] = true;
        for(dir in dirs){
            val newX = top.first + dir[0];
            val newY = top.second + dir[1];
            if(newX>=0 && newY>=0 && newX<grid.size && newY<grid[0].size && grid[newX][newY]==1 && !seen[newX][newY]){
                seen[newX][newY] = true;
                stack.push(Pair(newX, newY))
            }
        }
        ++area
    }
    return area;
}

fun main(){
    val array = arrayOf(intArrayOf(1,1), intArrayOf(1,1));
    print(maxAreaOfIsland(array));
}

