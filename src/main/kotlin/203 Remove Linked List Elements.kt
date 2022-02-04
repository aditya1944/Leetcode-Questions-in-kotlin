class Solution116 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return head
        }
        val dummyNode = ListNode(-1)
        dummyNode.next = head
        var ptr: ListNode? = dummyNode
        while (ptr?.next != null) {
            if (ptr.next!!.`val` == `val`) {
                ptr.next = ptr.next!!.next
            } else {
                ptr = ptr.next!!
            }
        }

        return dummyNode.next
    }
}