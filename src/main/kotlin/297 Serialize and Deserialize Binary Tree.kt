import java.util.*


class Codec {
    // Encodes a URL to a shortened URL.

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var currentIndex = 0

    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        val stringArray = ArrayList<String>()
        // do preorder traversal

        val stack = Stack<TreeNode?>()

        stack.push(root)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (node == null) {
                stringArray.add("X")
            } else {
                stringArray.add(node.`val`.toString())
                stack.push(node.right)
                stack.push(node.left)
            }
        }

        return stringArray.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) {
            return null
        }
        val arrayString = data.split(",")

        return helper(arrayString)
    }

    private fun helper(arrayString: List<String>): TreeNode? {
        if (currentIndex == arrayString.size) {
            return null
        }

        if (arrayString[currentIndex] == "X") {
            return null
        }
        val root = TreeNode(arrayString[currentIndex].toInt())


        ++currentIndex
        root.left = helper(arrayString)
        ++currentIndex
        root.right = helper(arrayString)
        return root
    }
}

fun main() {
    val a = Codec()

    val root = Codec.TreeNode(1)

    root.left = Codec.TreeNode(2)

    root.right = Codec.TreeNode(3)

    println(a.serialize(root))
    println(a.serialize(a.deserialize(a.serialize(root))))

}




