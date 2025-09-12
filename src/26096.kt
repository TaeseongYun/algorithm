import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dancers = HashSet<String>()
    dancers.add("ChongChong")

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken()
        val b = st.nextToken()

        if (a in dancers || b in dancers) {
            dancers.add(a)
            dancers.add(b)
        }
    }

    println(dancers.size)
}
