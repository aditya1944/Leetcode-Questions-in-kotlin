import kotlin.concurrent.timer

class Solution15 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun hasCycle(head: ListNode?): Boolean {
        if(head?.next == null){
            return false
        }
        var slow = head
        var fast = head.next
        while(slow!=fast){
            if(fast?.next != null && fast.next!!.next!=null){
                fast = fast.next!!.next
            }else{
                return false
            }
            slow = slow!!.next
        }
        return true
    }
}