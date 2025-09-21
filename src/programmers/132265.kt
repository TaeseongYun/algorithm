package programmers

class Solutions {
    fun solution(topping: IntArray): Int {
        val seenLeft = BooleanArray(1_000_001) { false }
        val seenRight = BooleanArray(1_000_001) { false }

        val left = IntArray(1_000_001) { 0 }
        val right = IntArray(1_000_001) { 0 }
        var count = 0
        var uniqueLeft = 0
        var uniqueRight = 0

        for (index in topping.indices) {
            val t = topping[index]
            if (seenLeft[t].not()) {
                seenLeft[t] = true
                uniqueLeft += 1
            }
            left[index] = uniqueLeft
        }

        for (index in topping.lastIndex downTo 0) {
            val t = topping[index]
            if (seenRight[t].not()) {
                seenRight[t] = true
                uniqueRight += 1
            }
            right[index] = uniqueRight
        }

        for (i in 0 .. topping.lastIndex) {
            if (left[i] == right[i+1]) {
                count += 1
            }
        }
        return count
    }
}

fun main() {
    val s = Solutions()

    println(s.solution(intArrayOf(1, 2, 3, 1, 4)))
}

