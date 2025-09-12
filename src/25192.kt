import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val tc = br.readLine().toInt()
    val gom = mutableMapOf<String, Boolean>()
    var count = 0
    repeat(tc) {
        val value = br.readLine()

        if (value == "ENTER") {
            count += gom.size
            gom.clear()
        } else {
            gom.putIfAbsent(value, true)
        }
    }

    count += gom.size
    println(count)
}
