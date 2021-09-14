import java.util.*

class Solution10 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = LinkedList<Int>()
        if(root==null){
            return list;
        }
        val stack = Stack<TreeNode>();
        stack.push(root);
        while(stack.isNotEmpty()){
            val top = stack.pop();
            list.addFirst(top.`val`);
            if(top.left!=null){
                stack.add(top.left);
            }
            if(top.right!=null){
                stack.add(top.right);
            }
        }
        return list;
    }
}