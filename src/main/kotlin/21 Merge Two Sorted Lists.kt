class Solution13 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        }
        if (l2 == null) {
            return l1
        }
        var temp1 = l1
        var temp2 = l2

        val head = if (l1.`val` < l2.`val`) {
            temp1 = temp1.next; l1
        } else {
            temp2 = temp2.next; l2
        }

        var temp: ListNode = head
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` < temp2.`val`) {
                temp.next = temp1
                temp1 = temp1.next
            } else {
                temp.next = temp2
                temp2 = temp2.next
            }
            temp = temp.next!!
            temp.next = null
        }

        while (temp1 != null) {
            temp.next = temp1
            temp1 = temp1.next
            temp = temp.next!!
            temp.next = null
        }

        while (temp2 != null) {
            temp.next = temp2
            temp2 = temp2.next
            temp = temp.next!!
            temp.next = null
        }

        return head
    }
}