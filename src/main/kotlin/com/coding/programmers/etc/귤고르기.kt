class 귤고르기 {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        val bucket: HashMap<Int, Int> = HashMap()

        for (i in tangerine) {
            bucket[i] = bucket.getOrDefault(i, 0) + 1
        }
        val sortedCounts = bucket.values.sortedDescending()

        var countSum = 0

        for (sortedCount in sortedCounts) {
            countSum += sortedCount
            answer++
            if (k >= countSum) {
                break
            }
        }

        return answer
    }
}