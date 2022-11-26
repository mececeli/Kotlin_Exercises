import java.util.*

//Valid Parentheses
//Easy
//16.9K
//871
//Companies
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false
//
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.

fun isValidParentheses(s: String): Boolean {
    if (s.length % 2 == 1) return false

    val openingBrackets: MutableList<Char> = mutableListOf()
    val closingBrackets: MutableList<Char> = mutableListOf()

    s.forEach { char ->
        if (isOpeningBracket(char)) {
            openingBrackets.add(char)
        } else {
            closingBrackets.add(char)
        }
    }

    if (openingBrackets.size == closingBrackets.size) {
        openingBrackets.forEachIndexed { index, char ->
            if (isSameTypeBracket(openingChar = char, closingChar = closingBrackets[index]).not()) {
                return false
            }
            return true
        }
    } else {
        return false
    }
    return false
}

fun isOpeningBracket(char: Char): Boolean = when (char) {
    '(', '[', '{' -> true
    else -> false
}

fun isSameTypeBracket(openingChar: Char, closingChar: Char): Boolean {
    if (openingChar == '(' && closingChar == ')') return true
    if (openingChar == '[' && closingChar == ']') return true
    if (openingChar == '{' && closingChar == '}') return true

    return false
}

//----------------------------------------------------------------------------- Stack Solution
fun isValidParenthesesStack(s: String): Boolean {
    if (s.length % 2 != 0) return false
    val map = mapOf('}' to '{', ')' to '(', ']' to '[')
    val stack = Stack<Char>()
    s.forEach {
        if (it == '}' || it == ')' || it == ']') {
            if (stack.isEmpty() || stack.peek() != map[it]) return false
            stack.pop()
        } else stack.push(it)
    }
    return stack.isEmpty()
}
