package com.coding.programmers.level0
import java.time.LocalTime

class 동영상재생기 {

    class Solution {
        fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
            //video_len : 재생길이
            val videoTime = parseLocalTime(video_len)
            //pos : 현재 재생위치
            var position = parseLocalTime(pos)
            //op_start : 오프닝 종료시간
            val opStart = parseLocalTime(op_start)
            //op_end : 오프닝 시작
            val opEnd = parseLocalTime(op_end)

            position = opening(position, opStart, opEnd)
            //commands: 재생 prev, next
            for (command in commands) {
                when (command) {
                    "prev" -> position = prevTime(position)
                    "next" -> position = nextTime(position, videoTime)
                }
                position = opening(position, opStart, opEnd)
            }

            return print(position)
        }
        private fun print(position: LocalTime): String {
            return String.format("%02d:%02d", position.minute, position.second)
        }

        private fun opening(position: LocalTime, opStart: LocalTime, opEnd: LocalTime): LocalTime {
            var result = position
            if (result in opStart..opEnd) {
                result = opEnd
            }
            return result
        }

        private fun prevTime(position: LocalTime): LocalTime {
            val prev = position.minusSeconds(10)

            if (prev > position) {
                return LocalTime.MIN
            }
            return prev
        }

        private fun nextTime(position: LocalTime, videoTime: LocalTime): LocalTime {
            val next = position.plusSeconds(10)
            return if (next >= videoTime) { videoTime } else next
        }

        private fun parseLocalTime(src: String): LocalTime {
            val videoSplit = src.split(":")
            return LocalTime.of(0, videoSplit[0].toInt(), videoSplit[1].toInt())
        }
    }
}