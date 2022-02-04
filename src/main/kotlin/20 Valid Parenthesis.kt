import java.util.*

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (char in s) {
        when (char) {
            '[', '(', '{' -> {
                stack.push(char)
            }
            else -> {
                if (stack.isEmpty()) {
                    return false
                }
                if (char == ']' && stack.peek() != '[') {
                    return false
                }
                if (char == '}' && stack.peek() != '{') {
                    return false
                }
                if (char == ')' && stack.peek() != '(') {
                    return false
                }
                stack.pop()
            }
        }
    }
    return stack.isEmpty()
}

