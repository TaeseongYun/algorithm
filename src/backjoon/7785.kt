package backjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val leave = "leave"
    val enter = "enter"

    val tc = br.readLine().toInt()
    val book = mutableSetOf<String>()

    repeat(tc) {
        val (user, action) = br.readLine().split(" ")

        when (action) {
            enter -> book.add(user)
            leave -> book.remove(user)
        }
    }

    print(book.sortedByDescending { it }.joinToString(separator = "\n"))
}
