import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()
    val rooms = mutableListOf<Pair<Int, Int>>()

    repeat(tc) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        rooms.add(start to end)
    }

    val sortedRoom = rooms.sortedWith(
        compareBy<Pair<Int, Int>> { (_, end) -> end }.thenBy { (start, _) -> start }
    )

    var lastEndTime = 0
    var count = 0

    for (room in sortedRoom) {
        val (s, e) = room
        if (lastEndTime <= s) {
            count += 1
            lastEndTime = e
        }
    }

    println(count)
}
