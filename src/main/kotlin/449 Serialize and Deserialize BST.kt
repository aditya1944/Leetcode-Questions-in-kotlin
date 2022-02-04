import java.util.*

class Codec1 {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val array = ArrayList<Int>()

        val stack = Stack<TreeNode>()

        stack.add(root)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            array.add(top.`val`)
            if (top.right != null) {
                stack.add(top.right)
            }
            if (top.left != null) {
                stack.add(top.left)
            }
        }
        return array.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }
        val array = data.split(",")
        val intArray = array.map { it.toInt() }

        return helper(intArray, 0, array.size - 1)
    }

    private fun helper(array: List<Int>, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        if (start == end) {
            return TreeNode(array[start])
        }
        val root = TreeNode(array[start])
        var index = start + 1
        while (index <= end && array[index] < array[start]) {
            ++index
        }

        root.left = helper(array, start + 1, index - 1)
        root.right = helper(array, index, end)

        return root
    }
}

fun main() {
    val a = Codec1()

    val root = TreeNode(11)

    root.left = TreeNode(9)

    root.right = TreeNode(12)

    root.right!!.right = TreeNode(20)


    /*root.right = TreeNode(9)
    root.right!!.left = TreeNode(12)
    root.right!!.left!!.right = TreeNode(20)*/

    println(a.serialize(root))
    println(a.serialize(a.deserialize(a.serialize(root))))
}