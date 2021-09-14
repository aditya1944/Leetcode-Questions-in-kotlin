import java.util.*

class Solution12 {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }


    fun connect(root: Node?): Node? {
        if(root==null){
            return root;
        }
        val queue = LinkedList<Node>();
        queue.addLast(root);
        while(queue.isNotEmpty()){
            var currentLevelSize = queue.size
            while(currentLevelSize>0){
                val top = queue.removeFirst()
                if(top.left!=null){
                    queue.addLast(top.left)
                }
                if(top.right!=null){
                    queue.addLast(top.right)
                }
                --currentLevelSize
                if(currentLevelSize!=0){
                    top.next = queue.first;
                }
            }
        }
        return root;
    }
}


fun main(){
    val root = Solution12.Node(1);
    root.left = Solution12.Node(2);
    root.right = Solution12.Node(3);

    Solution12().connect(root)
}