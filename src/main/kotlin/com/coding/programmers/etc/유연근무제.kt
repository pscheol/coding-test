import java.time.LocalTime
import kotlin.math.sqrt

class 유연근무제 {
    fun start() {
        val result = solution(
            intArrayOf(700, 800, 1155),
            arrayOf(
                intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
                intArrayOf(800, 801, 805, 800, 759, 810, 809),
                intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100),
            ),
            5
        )
        println(result)
    }
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        return timelogs.zip(schedules.map {
            it + if (it % 100 > 49) 50 else 10
        })
        .filter { (timeLog, limitTime) ->
            timeLog.filterIndexed { idx, i ->
                i > limitTime && !(idx == 6 - startday % 7 || idx == 7 - startday)
            }.isEmpty()
        }
        .size
    }

    fun solution2(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = schedules.size
        val weekend = setOf(6,7)

        schedules.forEachIndexed {index, hopeTime ->
            val checkTime = LocalTime.of((hopeTime / 100), (hopeTime % 100)).plusMinutes(10)
            var seqDay = startday

            for (timeLog in timelogs[index]) {
                println(seqDay)
                val workTime = LocalTime.of((timeLog / 100), (timeLog % 100))
                if (!weekend.contains(seqDay) && workTime.isAfter(checkTime)) {
                    answer--
                    break;
                }
                seqDay = if (seqDay == 7) 1 else ++seqDay
            }
        }

        return answer
    }
}