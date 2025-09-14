import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (node, line, start) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(node + 1) { false }
    val graph = Array(node + 1) {
        mutableListOf<Int>()
    }
    val visited_count = IntArray(node) { 0 }
    var when_count = 1

    for (g in 0 until line) {
        val (to, from) = br.readLine().split(" ").map { it.toInt() }

        graph[to].add(from)
        graph[from].add(to)
    }

    visited[start] = true
    visited_count[start - 1] = when_count


    fun bfs() {
        val q = ArrayDeque<Int>()

        q.add(start)

        while (q.isNotEmpty()) {
            val current = q.removeFirst()

            for (v in graph[current].sorted()) {
                if (visited[v].not()) {
                    q.add(v)
                    visited[v] = true
                    when_count += 1
                    visited_count[v - 1] = when_count
                }
            }
        }
    }

    bfs()

    print(visited_count.joinToString(separator = "\n"))
}
