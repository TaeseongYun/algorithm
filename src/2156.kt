import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val dp = Array(2) { -1 } // 0 0번부터 먹었을 때, 1 1번 부터 먹었을 때
    val podo = br.readLine().split("\n").map { it.toInt() }
    val maxContinue = 2

    dp[0] = podo[0] // 0 번째 먹었다고 가정

    for (index in 1 until maxContinue) {
        dp[0] += (podo[tc+index-5] + podo[tc+index-3] + podo[tc+index-2])
    }


    dp[1] = podo[1] // 1번째 먹었다고 가정


}