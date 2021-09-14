

class Solution14 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        var ptr1: ListNode? = head
        while(ptr1!=null){
            if(ptr1.next!=null && ptr1.`val`==ptr1.next!!.`val`){
                ptr1.next = ptr1.next!!.next
            }else{
                ptr1 = ptr1.next
            }
        }
        return head
    }
}