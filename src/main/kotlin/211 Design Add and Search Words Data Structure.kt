class WordDictionary {

    private val headNode: TrieNode

    init {
        headNode = TrieNode()
    }

    private class TrieNode {
        val neighbour = HashMap<Char, TrieNode>()
        var isEnd = false
    }


    fun addWord(word: String) {

        var tempNode = headNode
        for (char in word) {

            var newNode = tempNode.neighbour[char]

            if (newNode == null) {
                newNode = TrieNode()
            }

            tempNode.neighbour[char] = newNode

            tempNode = newNode
        }
        tempNode.isEnd = true
    }

    fun search(word: String): Boolean {
        return helper(word, 0, headNode)
    }

    private fun helper(word: String, index: Int, headNode: TrieNode): Boolean {
        if (index == word.length && headNode.isEnd) {
            return true
        }


        val tempNode = headNode.neighbour[word[index]]

        if (word[index].isLetter()) {

            if (tempNode == null) {
                return false
            }

            return helper(word, index + 1, tempNode)
        } else {
            // current digit is "."
            for (entry in headNode.neighbour) {
                val neighbourNode = headNode.neighbour[entry.key] ?: continue

                if (helper(word, index + 1, neighbourNode)) {
                    return true
                }
            }
        }

        return false

    }

}

fun main() {
    val dict = WordDictionary()
    dict.addWord("bad")
    println(dict.search("bad"))
    println(dict.search("..q"))
}