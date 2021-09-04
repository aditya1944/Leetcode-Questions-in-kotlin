import java.util.*
import kotlin.math.max
import kotlin.math.min

class MedianFinder() {

    private val minHeap = PriorityQueue<Int>();
    private val maxHeap = PriorityQueue<Int>(){a, b -> b-a};

    private fun balanceHeap():Unit{
        while(kotlin.math.abs(maxHeap.size - minHeap.size)>1){
            if(maxHeap.size> minHeap.size){
                val top = maxHeap.remove();
                minHeap.add(top);
            }else{
                val top = maxHeap.remove();
                minHeap.add(top);
            }
        }
    }

    fun addNum(num: Int) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
        }else if(num<maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        balanceHeap();
    }

    fun findMedian(): Double {
        return if(maxHeap.size>minHeap.size){
            maxHeap.peek().toDouble();
        }else if(minHeap.size>maxHeap.size){
            minHeap.peek().toDouble();
        }
        else{
            (maxHeap.peek().toDouble() + minHeap.peek().toDouble())/2;
        }
    }

}

fun main(){

}