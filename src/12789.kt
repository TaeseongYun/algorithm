import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }
    var next = 1
    val wait = ArrayDeque<Int>()

    for (a in array) {
        if (a == next) {
            next += 1
        } else {
            wait.add(a)
        }

        while (wait.isNotEmpty() && wait.last() == next) {
            wait.removeLast()
            next += 1
        }
    }

    while (wait.isNotEmpty() && wait.last() == next) {
        wait.removeLast()
        next += 1
    }

    println(if (next == tc + 1) "Nice" else "Sad")
}
