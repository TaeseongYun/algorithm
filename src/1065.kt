import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val target = br.readLine().toInt()
    var count = 0

    for (index in 1 .. target) {
        if (index < 100) {
            count += 1
        } else if(index < 1000) {
            val hundred = index / 100
            val ten = (index / 10) % 10
            val ones = index % 10

            if ((hundred - ten) == (ten - ones)) {
                count += 1
            }
        }
    }

    println(count)
}
