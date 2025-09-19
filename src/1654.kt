import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (tc, count) = br.readLine().split(" ").map { it.toInt() }

    val array = Array(tc) {
        br.readLine().toLong()
    }

    val end = array.max().toLong()

    fun binary(start: Long, end: Long): Long {
        if (start > end) return end

        val mid = (start + end) / 2

        var cnt = 0L

        for (cable in array) cnt += (cable / mid)


        return if (cnt >= count) {
            binary(mid + 1, end)
        } else {
            binary(start, mid - 1)
        }
    }

    println(binary(1L, end))
}
