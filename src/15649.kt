import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, pick) = br.readLine().split(" ").map { it.toInt() }
    val stack = ArrayDeque<Int>()

    fun backStack() {
        if (stack.size == pick) {
            println(stack.joinToString(" "))
            return
        }

        for (i in 1..N) {
            if (stack.contains(i).not()) {
                stack.add(i)
                backStack()
                stack.removeLast()
            }
        }
    }

    backStack()
}
