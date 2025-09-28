package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val target = br.readLine().split(" ").map { it.toInt() }
    repeat(M) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() - 1 }

        val sum = target.subList(start, end + 1).sum()


        println(sum)
    }
}
