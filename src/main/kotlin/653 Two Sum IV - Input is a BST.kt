class Solution2 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val set = HashSet<Int>()
        return inOrder(root, set, k)
    }

    private fun inOrder(root: TreeNode?, set: HashSet<Int>, k: Int): Boolean {
        if (root == null) {
            return false
        }

        if (set.contains(k - root.`val`)) {
            return true
        }

        set.add(root.`val`)

        if (inOrder(root.left, set, k)) {
            return true
        }

        if (inOrder(root.right, set, k)) {
            return true
        }
        return false
    }
}