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

    fun bfs(start: Int) {
        val queue = ArrayDeque<Int>()
        queue.add(start)
        visited[start] = true

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            for (near in q[current]) {
                if (visited[near].not()) {
                    visited[near] = true
                    queue.add(near)
                }
            }
        }
    }

    var linkedCount = 0
    for (n in 1..node) {
        if (visited[n].not()) {
            linkedCount+=1
            bfs(n)
        }
    }

    println(linkedCount)
}
