import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val tc = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }
    var times = 0
    val result = mutableListOf<Int>()

    for (a in array.sortedBy { it }) {
        result.add(times + a)
        times += a
    }

    println(result.sum())
}
