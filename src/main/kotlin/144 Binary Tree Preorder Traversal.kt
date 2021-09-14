import java.util.*


class Solution9 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val nodeList = mutableListOf<Int>();
        if(root==null){
            return nodeList;
        }
        val stack = Stack<TreeNode>();
        stack.push(root);
        while(stack.isNotEmpty()){
            val top = stack.pop();
            nodeList.add(top.`val`);
            if(top.right!=null){
                stack.push(top.right);
            }
            if(top.left!=null){
                stack.push(top.left);
            }
        }
        return nodeList;
    }
}