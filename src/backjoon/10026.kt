package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)
    val tc = br.readLine().toInt()
    val maps = Array(tc) {
        br.readLine().toMutableList()
    }
    val visited = Array(tc) {
        BooleanArray(tc) { false }
    }

    fun dfs(x: Int, y: Int) {
        if (x == tc && y == tc) return

        visited[x][y] = true
        val lastColor = maps[x][y]

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if (nx in 0 until tc && ny in 0 until tc && visited[nx][ny].not()) {
                val nextColor = maps[nx][ny]
                if (lastColor == nextColor) {
                    dfs(nx, ny)
                }
            }
        }
    }

    var normalGroup = 0

    for (x in 0 until tc) {
        for (y in 0 until tc) {
            if (visited[x][y].not()) {
                dfs(x, y)
                normalGroup += 1
            }
        }
    }

    // 적녹색약 맵 세팅
    for (x in 0 until tc) {
        for (y in 0 until tc) {
            if (maps[x][y] == 'G') {
                maps[x][y] = 'R'
            }
            visited[x][y] = false
        }
    }

    var noWatchingGreenGroup = 0

    for (x in 0 until tc) {
        for (y in 0 until tc) {
            if (visited[x][y].not()) {
                dfs(x, y)
                noWatchingGreenGroup += 1
            }
        }
    }

    println("$normalGroup $noWatchingGreenGroup")
}
