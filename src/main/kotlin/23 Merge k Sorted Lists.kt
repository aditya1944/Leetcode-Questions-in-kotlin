import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * */

class Solution {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        val pq = PriorityQueue<ListNode> { obj1: ListNode, obj2: ListNode -> obj1.`val` - obj2.`val` }

        for (node in lists) {
            if (node != null) {
                pq.add(node)
            }

        }
        var returnList: ListNode? = null
        var tailNode: ListNode? = null
        while (pq.isNotEmpty()) {
            val topNode = pq.peek()
            pq.remove()
            if (topNode.next != null) {
                pq.add(topNode.next)
            }
            if (topNode != null) {
                if (returnList == null) {
                    //this is node with smallest val
                    returnList = topNode
                } else {
                    tailNode!!.next = topNode
                }
                tailNode = topNode
            }
        }
        return returnList
    }
}



