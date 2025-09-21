package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (M, N, K) = br.readLine().split(" ").map { it.toInt() }
    val maps = Array(M) {
        IntArray(N) { 0 }
    }
    val nearBys = mutableListOf<Int>()
    val dx = listOf(1, 0, -1, 0)
    val dy = listOf(0, 1, 0, -1)

    //모눈종이 채울 그래프 입력 초기화
    for (i in 0 until K) {
        val (fx, fy, sx, sy) = br.readLine().split(" ").map { it.toInt() }

        // 그래프 모눈종이 채우기
        for (ni in fx until sx) {
            for (ny in fy until sy) {
                if (maps[ny][ni] != 1) {
                    maps[ny][ni] = 1
                }
            }
        }
    }

    // 모눈종이 방문 bfs
    fun bfs(start: Int, end: Int) {
        val q = ArrayDeque<Pair<Int, Int>>()
        q.add(start to end)
        maps[start][end] = 1
        var nearBy = 1

        while (q.isNotEmpty()) {
            val (x, y) = q.removeLast()

            for (index in 0 until 4) {
                val nx = dx[index] + x
                val ny = dy[index] + y

                if (nx in 0 until M && ny in 0 until N) {
                    if (maps[nx][ny] == 0) {
                        maps[nx][ny] = 1
                        nearBy += 1
                        q.add(nx to ny)
                    }
                }
            }
        }

        nearBys.add(nearBy)
    }

    var count = 0

    for (x in 0 until M) {
        for (y in 0 until N) {
            if (maps[x][y] != 1) { // 모눈종이가 채워지지 않은 곳을 방문
                bfs(x, y)
                count += 1
            }
        }
    }

    println(count)
    println(nearBys.sorted().joinToString(separator = " "))
}
