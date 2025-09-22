package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val maxInput = 40

    val dp = Array(maxInput + 1) {
        IntArray(2) { 0 }
    }

    dp[0][0] = 1
    dp[0][1] = 0
    dp[1][0] = 0
    dp[1][1] = 1

    for (index in 2 .. maxInput) {
        dp[index][0] = dp[index-1][0] + dp[index-2][0]
        dp[index][1] = dp[index-1][1] + dp [index-2][1]
    }


    repeat(tc) {
        val value = br.readLine().toInt()

        println("${dp[value][0]} ${dp[value][1]}")
    }
}
