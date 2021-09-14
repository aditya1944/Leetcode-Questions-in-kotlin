import java.util.*

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution18{

    class TreeNode(var `val`: Int){
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val returnList = mutableListOf<MutableList<Int>>()
        if(root==null){
            return returnList
        }
        val queue = LinkedList<TreeNode>();
        queue.addLast(root)
        while(queue.isNotEmpty()) {
            var currentQueueElementCount = queue.size;
            val currentLevelNodeList = mutableListOf<Int>()
            while(currentQueueElementCount!=0) {
                val top = queue.removeFirst()
                currentLevelNodeList.add(top.`val`)
                val leftNode = top.left
                if(leftNode!=null){
                    queue.addLast(top.left)
                }
                val rightNode = top.right
                if(rightNode!=null){
                    queue.addLast(rightNode)
                }
                --currentQueueElementCount
            }
            returnList.add(currentLevelNodeList)
        }
        return returnList;
    }
}