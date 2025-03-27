class DiscountEvent {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val wantMap = mutableMapOf<String, Int>()

        repeat(number.size) {
            wantMap[want[it]] = number[it]
        }

        repeat(discount.size - 9) {
            val discount10Map = mutableMapOf<String, Int>()

            for (j: Int in it until it + 10) {
                val discountItem = discount[j]
                if (wantMap.containsKey(discountItem)) {
                    discount10Map[discountItem] = discount10Map.getOrDefault(discountItem ,0) + 1
                }
            }

            if (discount10Map == wantMap) {
                answer++
            }

        }

        return answer
    }
}