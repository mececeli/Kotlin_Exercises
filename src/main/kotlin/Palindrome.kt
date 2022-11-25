/**
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 * For example, 121 is a palindrome while 123 is not.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 *
 * Constraints:
 * -2^31 <= x <= 2^31 - 1
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */

fun isPalindrome(x: Int): Boolean {
    //Eliminate cases if int starts with -
    if (x < 0) return false
    //Single numbers are palindrome
    if (x < 10) return true

    val digitList: MutableList<Int> = mutableListOf()
    var initialNum = x

    //Break down integer and put it in a list
    while (initialNum > 0) {
        val lastDigit = initialNum % 10
        initialNum /= 10
        digitList.add(lastDigit)
    }

    var start = 0
    var last = digitList.lastIndex
    //Compare each digit with first and last
    while (start < last) {
        val startDigit = digitList[start]
        val lastDigit = digitList[last]

        if (startDigit == lastDigit) {
            start++
            last--
        } else {
            return false
        }
    }

    return true
}

//Less complicated solution by converting integer to string
fun isPalindromeWithString(x: Int): Boolean = x.toString() == x.toString().reversed()