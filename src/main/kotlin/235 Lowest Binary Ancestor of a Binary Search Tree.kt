class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    if (p == null || q == null) {
        return null
    }
    if (root.`val` > p.`val` && root.`val` > q.`val`) {
        //lca lies on left side
        return lowestCommonAncestor(root.left, p, q)
    }
    if (root.`val` < p.`val` && root.`val` < q.`val`) {
        return lowestCommonAncestor(root.right, p, q)
    }
    if (root.`val` > p.`val` && root.`val` < q.`val` || root.`val` < p.`val` && root.`val` > q.`val`) {
        return root
    }
    if (root.`val` == p.`val`) {
        return root
    }
    if (root.`val` == q.`val`) {
        return root
    }
    return null
}