package leetcode

class Solution {
    private val numbers = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()


        val chars = digits.map { numbers[it].orEmpty() }
        val result = mutableListOf<String>()
        val visited = BooleanArray(chars.size) { false }
        fun backtrack(depth: Int, result: MutableList<String>, digitsLength: Int, char: String) {
            if (depth == digitsLength) {
                result.add(char)
                return
            }

            for (c in chars[depth]) {
                if (visited[depth].not()) {
                    visited[depth] = true
                    backtrack(depth = depth + 1, result, digitsLength, char = char + c)
                    visited[depth] = false
                }
            }
        }

        backtrack(depth = 0, result= result, digitsLength = digits.length, char = "")

        return result
    }
}

fun main() {
    val sol = Solution()
    println(sol.letterCombinations("2"))
}
