class FailRate {
    fun solution(N: Int, stages: IntArray): IntArray {
        val challenger = DoubleArray(N + 2)

        for (stage in stages) {
            challenger[stage]++
        }

        val fails = mutableMapOf<Int, Double>()
        var total = stages.size
        for (i: Int in 1..N) {
            if (challenger[i].toInt() == 0) {
                fails[i] = 0.0
                continue
            }
            fails[i] = challenger[i] / total
            total -= challenger[i].toInt()
        }

        return fails.entries
            .sortedByDescending { it.value }
            .map { it.key }
            .toIntArray()
    }
}