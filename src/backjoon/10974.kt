package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

// N 입력 -> N! 줄에 걸쳐서 모든 수열 나열

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val visited = BooleanArray(N+1) { false }
    val permutation = mutableListOf<Int>()


    fun backtrack(pick: Int) {
        if (pick == N) {
            println(permutation.joinToString(separator = " "))
            return
        }

        for (index in 1 .. N) {
            if (visited[index].not()) {
                visited[index] = true
                permutation.add(index)
                backtrack(pick + 1)
                permutation.remove(index)
                visited[index] = false
            }
        }
    }

    backtrack(0)
}
