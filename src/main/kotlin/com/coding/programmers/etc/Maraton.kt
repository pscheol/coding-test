class Maraton {
    fun solution(participant: Array<String>, completion: Array<String>): String {
        var answer = ""
        val map = mutableMapOf<String, Int>()

        for (s in completion) {
            map[s] = map.getOrDefault(s, 0) + 1
        }

        for (s in participant) {
            if (map[s] == 0) {
                answer = s
                break
            }

            map[s] = map[s]?: - 1
        }

        return answer
    }
}