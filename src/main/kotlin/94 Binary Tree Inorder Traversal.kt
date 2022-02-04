import java.util.*

class Solution3 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        var node = root
        val stack = Stack<TreeNode>()
        while (node != null) {
            stack.add(node)
            node = node.left
        }
        val returnVector = ArrayList<Int>()
        while (stack.isEmpty()) {
            val topNode = stack.pop()
            returnVector.add(topNode.`val`)
            var rightTreeRoot = topNode.right
            while (rightTreeRoot != null) {
                stack.push(rightTreeRoot)
                rightTreeRoot = rightTreeRoot.left
            }
        }
        return returnVector.toList()
    }
}