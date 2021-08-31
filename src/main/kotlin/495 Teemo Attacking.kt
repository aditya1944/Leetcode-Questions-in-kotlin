fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    var poisonDuration = 0;
    for(index in 1 until timeSeries.size){
        poisonDuration+=(kotlin.math.min(duration, timeSeries[index] - timeSeries[index-1]))
    }
    return poisonDuration + duration;
}


fun main(){
    print(findPoisonedDuration(intArrayOf(1,4), 2));
}