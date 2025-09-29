package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()


    val permutation = br.readLine().split(" ").map { it.toInt() }
    val max = permutation.max()
    val isPrime = BooleanArray(permutation.max() + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 0..sqrt(max.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * 2..max step i) {
                isPrime[j] = false
            }
        }
    }

    val primes = permutation.filter { isPrime[it] }

    if (primes.isEmpty()) println(-1) else {
        println(primes.reduce { acc, i -> acc * i })
    }
}
