import java.util.Stack

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = Stack<Int>()
    val returnArray = IntArray(temperatures.size)
    var index = temperatures.lastIndex
    while (index>=0){
        if (stack.isEmpty() ){
            // no temperature is larger in right side
            returnArray[index] = 0
            stack.push(index)
            --index
        }else {
            // some temperature on right side
            if (temperatures[stack.peek()] > temperatures[index]) {
                returnArray[index] = stack.peek() - index
                stack.push(index)
                --index
            }else{
                stack.pop()
            }
        }
    }
    return returnArray
}

fun main(){
    val array = dailyTemperatures(intArrayOf(30, 60, 90))

    for (num in array){
        println(num)
    }
}