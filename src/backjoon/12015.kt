package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val permutation = mutableListOf<Int>()
    val tc = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }


    // 바이너리 서치로 업데이트 할 인덱스 리턴.
    fun binary(low: Int, target: Int): Int {
        var end = permutation.size
        var start = low
        while (start < end) {
            val mid = (start + end) / 2

            if (target > permutation[mid]) {
                start = mid + 1
            } else {
                end = mid
            }
        }

        return start
    }

    for (index in 0 until tc) {
        if ((permutation.lastOrNull() ?: 0) < array[index]) {
            permutation.add(array[index])
        } else {
            val changeIndex = binary(low = 0, target = array[index])
            permutation[changeIndex] = array[index]
        }
    }

    println(permutation.size)
}
