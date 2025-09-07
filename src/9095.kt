import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val testCase = br.readLine().toInt()
    val sb = StringBuilder()

    Array(testCase) {
        val value = br.readLine().toInt()

        val dp = Array(value + 1) { 0 }

        if (value >= 1) dp[1] = 1
        if (value >= 2) dp[2] = 2
        if (value >= 3) dp[3] = 4

        if (value >= 4) {
            for (index in 4 .. value) {
                dp[index] = dp[index - 3] + dp[index - 2] + dp[index - 1]
            }
        }

        sb.append(dp[value])
        sb.appendLine()
    }

    println(sb)
}
