package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val array = br.readLine().split(" ").map { it.toInt() }.sorted()
    val visited = BooleanArray(N) { false }
    val result = mutableListOf<Int>()

    fun backtack(start: Int, pick: Int) {
        if (pick == M) {
            println(result.joinToString(separator = " "))
            return
        }

        for (index in start until N) {
            if (visited[index].not()) {
                visited[index] = true
                result.add(array[index])
                backtack(index + 1,pick + 1)
                result.remove(array[index])
                visited[index] = false
            }
        }
    }

    backtack(0, 0)
}
