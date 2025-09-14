import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val line = br.readLine().toInt()
    val visited = Array(line + 1) {
        BooleanArray(line + 1) { false }
    }
    val dx = listOf(-1, 0, 1, 0)
    val dy = listOf(0, -1, 0, 1)

    val graph = Array(line) {
        br.readLine().map { it.digitToInt() }
    }
    var build_count = 0
    val stringBuilder = StringBuilder()
    val result = mutableListOf<Int>()

    fun bfs(x: Int, y: Int) {
        var group_count = 1
        val q = ArrayDeque<Pair<Int, Int>>()

        q.add(x to y)
        visited[x][y] = true

        while (q.isNotEmpty()) {
            val (cx, cy) = q.removeFirst()

            for (d in 0 until 4) {
                val nx = dx[d] + cx
                val ny = dy[d] + cy
                if (nx in 0 until line && ny in 0 until line && visited[nx][ny].not() && graph[nx][ny] != 0) {
                    q.add(nx to ny)
                    group_count += 1
                    visited[nx][ny] = true
                }
            }
        }
        result.add(group_count)
    }

    for (x in 0 until line) {
        for (y in 0 until line) {
            if (visited[x][y].not() && graph[x][y] == 1) {
                bfs(x, y)
                build_count += 1
            }
        }
    }

    stringBuilder.append(build_count).appendLine()
    for (i in result.sorted()) {
        stringBuilder.append(i).appendLine()
    }
    print(stringBuilder)
}
