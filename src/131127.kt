

fun main() {
    class Solution {
        fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
            var answer: Int = 0
            val days = 10

            for (day in 0 .. discount.size - days) {
                var isValid = true
                val sliceDiscount = discount.slice(day until day + days).groupingBy { it }.eachCount()

                println(sliceDiscount)

                for (index in want.indices) {

                    val hasCount = sliceDiscount.getOrDefault(want[index], 0)
                    val needCount = number[index]


                    if (needCount > hasCount) {
                        isValid = false
                        break
                    }
                }

                if (isValid) {
                    answer += 1
                }
            }


            return answer
        }
    }

    val solution = Solution()

    println(solution.solution(
        want = arrayOf("banana", "apple", "rice", "pork", "pot"),
        number = intArrayOf(3, 2, 2, 2, 1),
        discount = arrayOf("chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana")
    ))

    // result -> 3

}