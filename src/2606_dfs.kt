import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val node = br.readLine().toInt()
    val line = br.readLine().toInt()
    val visited = BooleanArray(node + 1) { false }
    val virus = 1 // 1번 컴퓨터가 항상 감영
    val is_virus = BooleanArray(node + 1) { false }


    val graph = Array(node+ 1) {
        mutableListOf<Int>()
    }

    for (i in 0 until line) {
        val stringTokenizer = StringTokenizer(br.readLine())

        val start = stringTokenizer.nextToken().toInt()
        val end = stringTokenizer.nextToken().toInt()

        graph[start].add(end)
        graph[end].add(start)
    }


    fun dfs(start: Int) {
        visited[start] = true

        for (v in graph[start]) {
            if (visited[v].not()) {
                visited[v] = true
                is_virus[v] = true
                dfs(v)
            }
        }
    }

    dfs(virus)

    print(is_virus.count { it })
}
