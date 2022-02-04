import java.util.*

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val stack = Stack<Int>()
    for (index in nums2.size - 1 downTo 0) {
        if (stack.empty()) {
            stack.push(index)
        } else if (nums2[stack.peek()] > nums2[index]) {
            //element at top of stack is greater than the currentElement
            map[nums2[index]] = nums2[stack.peek()]
            stack.push(index)
        } else {
            //element at top of stack is less than equal to current Element
            while (!stack.empty() && nums2[index] > nums2[stack.peek()]) {
                stack.pop()
            }
            if (stack.empty()) {
                stack.push(index)
            } else {
                map[nums2[index]] = nums2[stack.peek()]
                stack.push(index)
            }
        }
    }
    val returnValue = IntArray(nums1.size)
    for (index in nums1.indices) {
        returnValue[index] = map.getOrDefault(nums1[index], -1)
    }
    return returnValue
}


fun main() {
    val array = nextGreaterElement(intArrayOf(), intArrayOf(1, 3, 4, 2))
    for (num in array) {
        print(num)
    }
}