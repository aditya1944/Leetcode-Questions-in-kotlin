class Solution6 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun middleNode(head: ListNode?): ListNode? {
        if (head!!.next == null) {
            return head
        }
        var slow = head
        var fast = head.next
        while (fast!!.next != null && fast.next!!.next != null) {
            slow = slow!!.next
            fast = fast.next
            fast = fast!!.next
        }
        return slow!!.next
    }

}