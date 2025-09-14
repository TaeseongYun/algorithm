import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (node, line, start) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(node + 1) { false }
    val graph = Array(node+1) {
        mutableListOf<Int>()
    }
    val visited_when = IntArray(node) { 0 }

    for (i in 0 until line) {
        val (to, from) = br.readLine().split(" ").map { it.toInt() }

        graph[to].add(from)
        graph[from].add(to)
    }

    var count = 1

    visited[start] = true

    fun dfs(start: Int) {
        visited_when[start-1] = count

        for (v in graph[start].sortedDescending()) {
            if (visited[v].not()) {
                visited[v] = true
                count += 1
                dfs(v)
            }
        }
    }


    dfs(start)

    print(visited_when.joinToString(separator = "\n"))
}
