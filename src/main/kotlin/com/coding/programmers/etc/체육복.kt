class 체육복 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n
        val arr = IntArray(n + 1) { 0 }

        val lostset = lost.toSet() - reserve.toSet()

        for (l in lost) {
            arr[l]--
        }
        for (r in reserve) {
            arr[r]++
        }


        for (i: Int in 1 until arr.size) {
            if (arr[i] == -1) {
                continue
            }

            if (i - 1 > 0 && arr[i - 1] == 1) {
                arr[i - 1]--
                arr[i]++
            } else if (i + 1 < arr.size && arr[i + 1] == 1) {
                arr[i + 1]--
                arr[i]++
            } else {
                answer--
            }
        }

        return answer
    }
}