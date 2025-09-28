package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val find = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val repeat = br.readLine().toInt()
    val family = Array(N + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(N + 1) { false }
    var answer = 0

    for (i in 0 until repeat) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        family[start].add(end)
        family[end].add(start)
    }

    fun dfs(index: Int, depth: Int) {
        if (find.contains(index)) {
            answer = depth
            find.remove(index)
        }

        for (number in family[index]) {
            if (visited[number].not()) {
                visited[index] = true
                dfs(number, depth + 1)
            }
        }
    }

    dfs(find.first(), depth = 0)

    if (find.isNotEmpty()) println(-1) else println(answer)
}
