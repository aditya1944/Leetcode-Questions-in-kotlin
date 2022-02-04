import java.util.*

class Solution4 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        // will perform inorder iteratively

        val stack = Stack<TreeNode>()
        insertCurrentAndLeft(root, stack)
        var oldNode: Int? = null
        while (stack.isNotEmpty()) {
            val topNode = stack.pop()
            if (oldNode != null) {
                //this is more than first time
                if (oldNode >= topNode.`val`) {
                    return false
                }
            }
            oldNode = topNode.`val`
            insertCurrentAndLeft(topNode.right, stack)
        }
        return true
    }

    private fun insertCurrentAndLeft(root: TreeNode?, stack: Stack<TreeNode>) {
        if (root == null) {
            return
        }
        var node: TreeNode = root
        stack.push(node)
        while (node.left != null) {
            stack.push(node.left)
            node = node.left!!
        }
    }
}

