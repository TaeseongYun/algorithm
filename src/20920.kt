import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    /***
     * 조건
     *
     * 자주 나오는 단어일수록 앞에 배치한다.
     * 해당 단어의 길이가 길수록 앞에 배치한다.
     * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
     ***/
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (tc, minLength) = br.readLine().split(" ").map { it.toInt() }

    val alpha = Array(tc) {
        br.readLine()
    }.filter { it.length >= minLength }

    val alphaToMap = alpha.groupingBy { it }.eachCount()


    println(
        alphaToMap.entries.sortedWith(
            compareByDescending<Map.Entry<String, Int>> { it.value }
                .thenByDescending { it.key.length }
                .thenBy { it.key }
        ).joinToString(separator = "\n") { it.key })
}
