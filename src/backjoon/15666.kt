package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    /***
     * 같은 수 골라도 가능
     * 중복된 수열 불가
     ***/

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (tc, pick) = br.readLine().split(" ").map { it.toInt() }
    val array = br.readLine().split(" ").map { it.toInt() }.sorted()

    val picks = mutableListOf<Int>()

    fun backtrack(depth: Int, startIndex: Int) {
        if (pick == depth) {
            println(picks.joinToString(" "))
            return
        }

        var prev = Int.MIN_VALUE
        for (i in startIndex until tc) {
            if (array[i] == prev) continue
            picks.add(array[i])
            backtrack(depth + 1, i)
            picks.removeLast()
            prev = array[i]
        }
    }

    backtrack(0, 0)
}
