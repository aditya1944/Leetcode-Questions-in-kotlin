import java.util.*

fun orangesRotting(grid: Array<IntArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>();
    var initialFreshOrangeCount = 0;
    for(rowIndex in grid.indices){
        for(colIndex in grid[rowIndex].indices){
            if(grid[rowIndex][colIndex]==2){
                queue.add(Pair(rowIndex,colIndex));
            }else if(grid[rowIndex][colIndex]==1){
                ++initialFreshOrangeCount;
            }
        }
    }
    if(queue.isEmpty() && initialFreshOrangeCount>0){
        //no bad oranges exists
        return -1;
    }
    if(queue.isNotEmpty() && initialFreshOrangeCount==0){
        //bad oranges exists but no fresh orange exists
        return 0;
    }
    if(queue.isEmpty() && initialFreshOrangeCount == 0){
        //bad oranges do not exists and no fresh oranges exists
        return 0;
    }
    // there are rotten oranges and fresh oranges
    val dirs = arrayOf(intArrayOf(0,1), intArrayOf(0,-1), intArrayOf(1,0), intArrayOf(-1,0));
    var timeTaken = 0;
    while(queue.isNotEmpty()){
        var currentLevelSize = queue.size;
        ++timeTaken;
        while(currentLevelSize>0){
            --currentLevelSize;
            val pair = queue.remove();
            for(dir in dirs){
                val newX = dir[0] + pair.first;
                val newY = dir[1] + pair.second;
                if(newX<0 || newY<0 || newX>=grid.size || newY>=grid[0].size){
                    continue;
                }
                if(grid[newX][newY]==1){
                    grid[newX][newY] = 2;
                    --initialFreshOrangeCount;
                    queue.add(Pair(newX, newY));
                }
            }
        }

    }
    if(initialFreshOrangeCount!=0){
        return -1;
    }
    return timeTaken-1;
}


fun main(){
    print(orangesRotting(arrayOf(intArrayOf(2,1,1), intArrayOf(1,1,0), intArrayOf(0,1,1))));
}