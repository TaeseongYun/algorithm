package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }
    val M = br.readLine().toInt()
    var start = 0
    var end = array.max()
    var answer = 0

    while (start <= end) {
        val mid = (start + end) / 2

        var sum = 0

        for (a in array) {
            val value = if (mid < a) {
                mid
            } else {
                a
            }

            sum += value
        }

        if (sum <= M) {
            answer = mid
            start = mid + 1
        } else  {
            end = mid - 1
        }
    }

    println(answer)
}
