import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.Arrays

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val set = BooleanArray(21)
    val out = StringBuilder()

    repeat(tc) {
        val st = StringTokenizer(br.readLine())
        val cmd = st.nextToken()
        val x = if (st.hasMoreTokens()) st.nextToken().toInt() else 0

        when (cmd) {
            "add" -> {
                set[x] = true
            }
            "remove" -> {
                set[x] = false
            }
            "check" -> {
                out.append(if (set[x]) 1 else 0).append('\n')
            }
            "toggle" -> {
                set[x] = !set[x]
            }
            "all" -> {
                Arrays.fill(set, true)
            }
            "empty" -> {
                Arrays.fill(set, false)
            }
        }
    }

    print(out)
}

