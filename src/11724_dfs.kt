import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (node, line) = br.readLine().split(" ").map { it.toInt() }

    val q = Array(node + 1) {
        mutableListOf<Int>()
    }
    val visited = BooleanArray(node + 1) { false }

    repeat(line) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }

        q[start].add(end)
        q[end].add(start)
    }

    fun dfs(start: Int) {
        visited[start] = true
        for (v in q[start]) {
            if (visited[v].not()) {
                dfs(v)
            }
        }
    }

    var linkedCount = 0

    for (i in 1..node) {
        if (visited[i].not()) {
            dfs(i)
            linkedCount += 1
        }
    }

    println(linkedCount)
}
