import java.util.*

class Solution3{
    class TreeNode(var `val`: Int){
        var left: TreeNode? = null;
        var right: TreeNode? = null;
    }

    fun inorderTraversal(root: TreeNode?): List<Int>{
        val returnList = mutableListOf<Int>();
        if(root==null){
            return returnList;
        }
        val stack = Stack<TreeNode>();
        insertLeft(root, stack)
        while(stack.isNotEmpty()){
            val topNode = stack.pop();
            returnList.add(topNode.`val`);
            if(topNode.right!=null){
                insertLeft(topNode.right!!, stack);
            }
        }
        return returnList;
    }

    private fun insertLeft(root: TreeNode, stack: Stack<TreeNode>){
        var node = root;
        stack.push(node);
        while(node.left!=null){
            stack.push(node.left);
            node = node.left!!;
        }
    }
}