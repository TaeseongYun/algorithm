import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val stringTokenizer = StringTokenizer(br.readLine())
    val tc = stringTokenizer.nextToken().toInt()
    val target = stringTokenizer.nextToken().toInt()
    var extra = target
    var count = 0

    val coins = Array(tc) {
        br.readLine().toInt()
    }.sortedDescending()


    for (c in coins) {
        if (extra == 0) {
            break
        }

        count += extra / c
        extra %= c
    }

    print(count)
}
