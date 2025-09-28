package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, target) = br.readLine().split(" ").map { it.toInt() }
    val array = br.readLine().split(" ").map { it.toInt() }
    var i = 0
    var j = 0

    if (target == 0) return

    var count = 0
    var sum = 0
    while (true) {
        when {
            sum >= target -> {
                if (sum == target) count += 1
                sum -= array[i]
                i += 1
            }
            j == N -> {
                break
            }
            else -> {
                sum += array[j]
                j += 1
            }
        }
    }

    println(count)
}
