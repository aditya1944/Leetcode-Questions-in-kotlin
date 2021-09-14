import java.util.*

class Solution5{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        //do inorder traversal
        if(k==1){
            return root!!.`val`;
        }
        var tempK = 1;
        val stack = Stack<TreeNode>();
        insertCurrentAndLeft(root, stack);
        while(stack.isNotEmpty()){
            val topNode = stack.pop();
            if(tempK==k){
                return topNode.`val`
            }
            insertCurrentAndLeft(topNode.right, stack);
            ++tempK;
        }
        return -1;
    }

    private fun insertCurrentAndLeft(root: TreeNode?, stack: Stack<TreeNode>){
        if(root==null){
            return;
        }
        stack.push(root);
        var node = root;
        while(node!!.left!=null){
            stack.add(node.left);
            node = node.left;
        }
    }

}

fun main(){
    val head = Solution5.TreeNode(3);
    head.left = Solution5.TreeNode(1);
    head.right = Solution5.TreeNode(4);
    head.left!!.right = Solution5.TreeNode(2);
    Solution5().kthSmallest(head, 1);
}