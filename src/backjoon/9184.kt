package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val max = 20
    val dp = Array(max + 1) {
        Array(max + 1) {
            IntArray(max + 1) {
                0
            }
        }
    }

    fun w(a: Int, b: Int, c: Int): Int {
        if (a <= 0 || b <= 0 || c <= 0) return 1

        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20)

        if (dp[a][b][c] != 0) return dp[a][b][c]

        dp[a][b][c] = if (a < b && b < c) {
            w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c)
        } else {
            w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1)
        }
        return dp[a][b][c]
    }

    while(true) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

        if (a == -1 && b == -1 && c == -1) break

        println("w($a, $b, $c) = ${w(a,b,c)}")
    }
}
