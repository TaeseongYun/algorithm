package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val repeat = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()

    fun binary(low: Int, target: Int): Int {
        var start = low
        var end = result.size
        while (start < end) {
            val mid = (start + end) / 2

            if (target < result[mid]) {
                start = mid + 1
            } else {
                end = mid
            }
        }

        return start
    }

    for (index in 0 until repeat) {
        if ((result.lastOrNull() ?: 0) == array[index]) continue
        if (result.isEmpty() || result.last() > array[index]) {
            result.add(array[index])
        } else {
            val changeIndex = binary(0, array[index])
            result[changeIndex] = array[index]
        }
    }

    println(result.size)
}
