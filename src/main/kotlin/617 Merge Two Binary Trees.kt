

class Solution11 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {

        var returnNode: TreeNode? = null;
        if(root1!=null && root2!=null){
            returnNode = TreeNode(root1.`val` + root2.`val`);
            returnNode.left = mergeTrees(root1.left, root2.left)
            returnNode.right = mergeTrees(root1.right, root2.right)
        }else if(root1==null && root2!=null){
            returnNode = TreeNode(root2.`val`);
            returnNode.left = mergeTrees(null, root2.left)
            returnNode.right = mergeTrees(null, root2.right)
        }else if(root1!=null && root2==null){
            returnNode = TreeNode(root1.`val`)
            returnNode.left = mergeTrees(root1.left, null)
            returnNode.right = mergeTrees(root1.right, null)
        }else{
            returnNode = null;
        }

        return returnNode;
    }

}

