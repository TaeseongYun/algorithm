import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val st = StringTokenizer(br.readLine())
    val tc = st.nextToken().toInt()
    val target = if (st.hasMoreTokens()) st.nextToken().toInt() else 0

    if (target == 0) return
    val array = br.readLine().split(" ").map { it.toInt() }

    var count = 0
    var i = 0
    var j = 0

    var sum = 0
    while (true) {
        when {
            sum >= target -> {
                if (sum == target) count++
                sum -= array[i]
                i++
            }
            j == tc -> break
            else -> {
                sum += array[j]
                j++
            }
        }
    }

    println(count)
}
