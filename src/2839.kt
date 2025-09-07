import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val target = br.readLine().toInt()
    var extra = target
    val five = 5
    val three = 3

    var count = 0

    while(true) {
        if (extra < three) {
            break
        }

        if (extra >= five) {
            if (extra % five == 0) {
                extra -= five
            } else {
                extra -= three
            }
            count += 1
        } else {
            extra -= three
            count += 1
        }
    }

    if (extra != 0) {
        println(-1)
    } else {
        println(count)
    }
}
