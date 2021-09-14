class Solution17{
    class TreeNode(var `val`: Int){
        var left: TreeNode? = null;
        var right: TreeNode? = null;
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean{
        val currentSum: Int? = null;
        return helper(root, targetSum, currentSum)
    }

    private fun helper(node: TreeNode?, targetSum:Int, currentSum: Int?): Boolean{
        if(node==null){
            return false
        }
        val sumIncludingCurrentNode = if(currentSum==null) node.`val` else node.`val` + currentSum

        if(sumIncludingCurrentNode==targetSum && node.left==null && node.right==null){
            //this is leaf node
            return true
        }

        return helper(node.left, targetSum, sumIncludingCurrentNode) || helper(node.right, targetSum, sumIncludingCurrentNode)
    }
}