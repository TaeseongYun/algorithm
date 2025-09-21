package programmers

class Solution {
    fun solution(s: String): IntArray {
        val target = s.substring(2, s.lastIndex - 1).split("},{").sortedBy { it.length }
            .joinToString(separator = " // ")
            .split(" // ")

        val set = mutableSetOf<Int>()

        for (t in target) {
            val value = t.split(",")
            for (v in value) {
                set.add(v.toInt())
            }
        }

        return set.toIntArray()
    }
}

fun main() {
    val s = Solution()
    s.solution("{{20,111},{111}}")
}