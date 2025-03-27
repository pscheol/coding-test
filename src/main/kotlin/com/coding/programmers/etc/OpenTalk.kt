import java.util.StringTokenizer

class OpenTalk {
    fun solution(record: Array<String>): Array<String> {
        val message = mapOf<String, String>(
            "Enter" to "님이 들어왔습니다.",
            "Leave" to "님이 나갔습니다."
        )
        val userMap = mutableMapOf<String, String>()


        for (r in record) {
            val commands = r.split(" ")
            if (commands.size == 3) {
                userMap[commands[1]] = commands[2]
            }
        }

        var answer = mutableListOf<String>()
        for (r in record) {
            val tokenizer = StringTokenizer(r, " ")
            val command = tokenizer.nextToken()

            if (message.containsKey(command)) {
                val id = tokenizer.nextToken()
                answer.add(userMap[id] + message[command])
            }
        }

        return answer.toTypedArray()
    }
}