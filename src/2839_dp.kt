import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val target = br.readLine().toInt()
    val dp = Array(target + 1) { Int.MAX_VALUE }

    dp[0] = 0

    for (i in 1..target) {
        if (i >= 3 && dp[i - 3] != Int.MAX_VALUE) {
            dp[i] = min(dp[i - 3] + 1, dp[i])
        }

        if (i >= 5 && dp[i - 5] != Int.MAX_VALUE) dp[i] = minOf(dp[i], dp[i - 5] + 1)
    }

    println(if (dp[target] != Int.MAX_VALUE) dp[target] else -1)
}
