class MinStack() {

    private var head: Node? = null;

    fun push(`val`: Int) {
        head = if(head==null){
            Node(`val`, `val`, null);
        }else{
            Node(`val`, kotlin.math.min(head!!.minValue, `val`), head);
        }
    }

    fun pop() {
        var topNode = head;
        head = head!!.next;
        topNode!!.next = null;
    }

    fun top(): Int {
        return head!!.value;
    }

    fun getMin(): Int {
        return head!!.minValue
    }
    private class Node(_value: Int, _minValue:Int, _next: Node?){
        val value = _value;
        val minValue = _minValue;
        var next = _next;
    }
}

fun main(){
    val minStack = MinStack();

}