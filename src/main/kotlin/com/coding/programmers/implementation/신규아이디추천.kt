package com.coding.programmers.implementation

import java.util.*

class 신규아이디추천 {
    fun solution(new_id: String): String {
        var answer: String = new_id.lowercase()
        answer = answer.replace("[~!@#\$%^&*()=+\\[\\]{}:?,<>/]".toRegex(), "")
        answer = answer.replace("\\.{2,}".toRegex(), "") //. 2개 이상연결
        answer = answer.replace("^\\.|\\.\$".toRegex(), "") //처음과 끝 마침표 제거

        if (answer.isEmpty()) {
            for (i in 0..2) {
                answer += "a"
            }
        } else {
            answer = answer.replace(" ".toRegex(), "a")
            if (answer.length >= 16) {
                answer = answer.substring(0, 15)
                answer = answer.replace("^\\.|\\.\$".toRegex(), "")
            }
            if (answer.length <= 2) {
                while(answer.length <3) {
                    answer += answer[answer.length - 1]
                }
            }
        }
        return answer
    }

    fun solution2(new_id: String): String {

        var answer = new_id.lowercase(Locale.getDefault()) //소문자로
        answer = answer.replace("[~!@#$%^&*()=+\\[\\]{}:?,<>/]".toRegex(), "") //특수문자 제거
        answer = answer.replace("\\.{2,}".toRegex(), ".") //. 마침표 하나로 변환

        answer = answer.replace("^\\.|\\.$".toRegex(), "") //. 제거

        if (answer.length == 0) {
            for (i in 0..2) {
                answer += "a"
            }
        } else {
            answer = answer.replace(" ".toRegex(), "a") //. 빈문자열 s로 변환

            if (answer.length >= 16) {
                answer = answer.substring(0, 15)
                answer = answer.replace("^\\.|\\.$".toRegex(), "") //. 제거
            }

            if (answer.length <= 2) {
                while (answer.length < 3) {
                    answer += answer[answer.length - 1]
                }
            }
        }

        return answer
    }
}