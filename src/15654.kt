import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val array = br.readLine().split(" ").map { it.toInt() }.sorted()
    val pickNumber = mutableListOf<Int>()

    fun dfs(depth: Int) {
        if (depth == M) {
            println(pickNumber.joinToString(separator = " "))
            return
        }

        for (i in 0 until N) {
            if (pickNumber.contains(array[i]).not()) {
                pickNumber.add(array[i])
                dfs(depth+1)
                pickNumber.removeLast()
            }
        }
    }

    dfs(0)
}
