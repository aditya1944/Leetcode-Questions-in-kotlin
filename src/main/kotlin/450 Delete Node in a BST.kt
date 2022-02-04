class Solution21 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) {
            return root
        }
        if (root.left == null) {
            return root.right
        }

        if (root.right == null) {
            return root.left
        }

        var rightNode = root.right
        while (rightNode!!.left != null) {
            rightNode = rightNode.left
        }
        root.`val` = rightNode.`val`
        root.right = deleteNode(root.right, key)
        return root
    }

}