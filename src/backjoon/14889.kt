package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val maps = Array(N) {
        br.readLine().split(" ").map { it.toInt() }
    }
    val visited = BooleanArray(N) { false }
    var answer = Int.MAX_VALUE

    visited[0] = true
    fun caldiff(): Int {
        var startTeam = 0
        var linkTeam = 0
        for (i in 0 until N) {
            for (j in i+1 until N) {
                val add = maps[i][j] + maps[j][i]

                if (visited[j] && visited[i]) { startTeam += add }
                else if(visited[j].not() && visited[i].not()) { linkTeam += add }
            }
        }

        return abs(startTeam - linkTeam)
    }

    fun backtrack(index: Int, pick: Int) {
        if (index >= N) return
        if (pick == N / 2) {
            answer = min(answer, caldiff())
            return
        }


        visited[index] = true
        backtrack(index + 1, pick + 1)
        visited[index] = false
        backtrack(index + 1, pick)
    }

    backtrack(0, 0)

    println(answer)
}
