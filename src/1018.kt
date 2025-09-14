import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val cheese = Array(N) {
        br.readLine()
    }

    var answer = Int.MAX_VALUE

    for (i in 0 .. N-8) {
        for (j in 0 .. M-8) {
            var w_count = 0
            var b_count = 0
            for (x in i until i+8) {
                for (y in j until j+8) {
                    val same = (x+y) % 2 == (i+j) % 2
                    val startB = if (same) 'B' else 'W'
                    val startW = if (same) 'W' else 'B'

                    if (startB != cheese[x][y]) { b_count += 1 }
                    if (startW != cheese[x][y]) { w_count += 1 }
                }
            }
            answer = min(answer, min(b_count, w_count))
        }
    }

    print(answer)

    //print(cheese.joinToString(separator = "\n"))
}
