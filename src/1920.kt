import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val tc = br.readLine().toInt()
    val target_list = br.readLine().split(" ").map { it.toInt() }.sorted()
    val second_target = br.readLine().toInt()
    val value = br.readLine().split(" ").map { it.toInt() }
    val answer = IntArray(second_target) { 0 }

    var index = 0

    fun b_search(first: Int, last: Int, target: Int) {
        if (first > last) {
            index += 1
            return
        }
        val mid = (first + last) / 2


        if (target == target_list[mid]) {
            answer[index] = 1
            index += 1
            return
        } else if (target > target_list[mid]) {
            return b_search(first = mid + 1, last = last, target = target)
        } else {
            return b_search(first = first, last = mid - 1, target = target)
        }
    }

    for (v in value) {
        b_search(0, tc - 1, v)
    }

    print(answer.joinToString(separator = "\n"))
}
