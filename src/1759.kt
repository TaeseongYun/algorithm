import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (pick, tc) = br.readLine().split(" ").map { it.toInt() }
    val letter = br.readLine().split(' ').sortedBy { it }
    val password = ArrayDeque<String>()
    val jaum = listOf("a", "e", "i", "o", "u")

    fun backtrack(start: Int) {
        if (password.size > pick) return

        if (password.size == pick) {
            val (jaumCount, moumCount) = password.partition { it in jaum }
            if (jaumCount.isNotEmpty() && moumCount.size >= 2) {
                println(password.joinToString(separator = ""))
                return
            }
        }

        for (i in start until tc) {
            if (password.contains(letter[i]).not()) {
                password.add(letter[i])
                backtrack(i + 1)
                password.removeLast()
            }
        }
    }

    backtrack(0)
}


/***
 * acis
 * acit
 * aciw
 * acst
 * acsw
 * actw
 * aist
 * aisw
 * aitw
 * astw
 * cist
 * cisw
 * citw
 * istw
 *
 ***/