class Solution8{
    class ListNode(var value: Int){
        var next: ListNode? = null;
    }
    // this is iterative
    fun reverseList(head: ListNode?): ListNode? {
        var prev:ListNode? = null;
        var next: ListNode? = null;
        var curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


