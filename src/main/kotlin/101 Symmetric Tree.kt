class Solution19 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return helper(root.left, root.right)
    }

    private fun helper(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null && node2 == null) {
            return true
        }
        val node1Value = node1?.`val`
        val node2Value = node2?.`val`

        if (node1Value == node2Value) {
            val isLeftTreeSymmetric = helper(node1?.left, node2?.left)
            val isRightTreeSymmetric = helper(node1?.right, node2?.right)
            return isLeftTreeSymmetric && isRightTreeSymmetric

        }
        return false

    }
}