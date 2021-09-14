import java.util.*

class MyQueue() {

    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()

    /** Push element x to the back of queue. */
    fun push(x: Int) {
        s1.push(x)
    }

    /** Removes the element from in front of queue and returns that element. */
    fun pop(): Int {
        if(s2.isEmpty()){
            while(s1.isNotEmpty()){
                s2.push(s1.pop())
            }
        }
        return s2.peek()
    }

    /** Get the front element. */
    fun peek(): Int {
        if(s2.isEmpty()){
            while(s1.isNotEmpty()){
                s2.push(s1.pop())
            }
        }
        return s2.peek()
    }

    /** Returns whether the queue is empty. */
    fun empty(): Boolean {
        if(s1.isEmpty() && s2.isEmpty()){
            return true
        }
        return false
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */