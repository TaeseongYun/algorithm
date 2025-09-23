package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val tc = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val visited = BooleanArray(tc) { false }
    var answer = 0


    fun backtrace(nextPosition: Int, pick: Int, sum: Int) {
        if (pick == tc) {
            answer = max(sum, answer)
            return
        }


        for (i in 0 until tc) {
            if (visited[i].not()) {
                visited[i] = true
                val add = abs(array[nextPosition] - array[i])
                backtrace(nextPosition = i, pick = pick + 1, sum = sum + add)
                visited[i] = false
            }
        }
    }

    for (i in 0 until tc) {
        visited[i] = true
        backtrace(nextPosition = i, pick = 1, sum = 0)
        visited[i] = false
    }

    println(answer)
}
