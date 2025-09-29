package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val targets = Array(n) { br.readLine().toInt() }
    val q = ArrayDeque<Int>()
    val math = mutableListOf<Char>()
    var nextValue = 1

    for (target in targets) {
        while (true) {
            if (q.isEmpty() || q.last() != target) {
                if (nextValue > n) {
                    println("NO")
                    return
                }
                math.add('+')
                q.add(nextValue)
            } else if (q.last() == target) {
                q.removeLast()
                math.add('-')
                break
            }
            nextValue += 1
        }
    }

    println(math.joinToString(separator = "\n"))
}
