import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (first, last) = br.readLine().split(" ").map { it.toInt() }
    val firstArray = Array(first) {
        ""
    }
    val secondsArray = Array(last) {
        ""
    }
    repeat(first) {
        val value = br.readLine()

        firstArray[it] = value
    }
    repeat(last) {
        val value = br.readLine()

        secondsArray[it] = value
    }

    println(secondsArray.count { it in firstArray })
}
