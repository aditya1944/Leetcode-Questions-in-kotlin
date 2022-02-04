import java.util.*

class Solution22 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun recoverTree(root: TreeNode?): Unit {
        val stack = Stack<TreeNode>()
        var temp = root
        while (temp != null) {
            stack.push(temp)
            temp = temp.left
        }
        var incorrectNode1: TreeNode? = null
        var incorrectNode2: TreeNode? = null
        var prevNode: TreeNode? = null
        while (stack.isNotEmpty()) {
            val topNode = stack.pop()
            if (prevNode == null) {
                prevNode = topNode
            } else {
                if (prevNode.`val` > topNode.`val`) {
                    if (incorrectNode1 == null) {
                        incorrectNode1 = prevNode
                    } else {
                        incorrectNode2 = prevNode
                        break
                    }
                }
            }
            if (topNode.right != null) {
                var temp = topNode.right
                while (temp != null) {
                    stack.push(temp)
                    temp = temp.left
                }
            }
        }
        incorrectNode1 ?: return
        incorrectNode2 ?: return
        var tempValue = incorrectNode1.`val`
        incorrectNode1.`val` = incorrectNode2.`val`
        incorrectNode2.`val` = tempValue
    }
}


