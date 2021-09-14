class Solution7{
    class ListNode(var `val`: Int){
        var next: ListNode? = null;
    }



    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummyNode = ListNode(-1);
        dummyNode.next = head;
        var left = dummyNode;
        var right = dummyNode;
        for(count in 1..n){
            left = left.next!!;
        }

        while(right.next!=null){
            left = left.next!!;
            right = right.next!!;
        }

        left.next = left.next!!.next;

        return dummyNode.next;
    }


}