class MultiLevelToothBrushSales {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val parents: MutableMap<String, Seller> = mutableMapOf()

        for (i in enroll.indices) {
            val enr = enroll[i]; //판매원
            val ref = referral[i]; //추천인
            val refSeller = parents.getOrDefault(ref, Seller(ref))
            if (!parents.containsKey(enr)) {
                parents[enr] = Seller(enr, refSeller)
            }
        }

        for (i in seller.indices) {
            parents[seller[i]]?.reward(100 * amount[i])
        }

        return parents.values
            .map { it.amount }.toIntArray()
    }

    data class Seller(
        val name: String,
        val parent: Seller? = null,
        var amount: Int = 0,
    ) {
        fun reward(amount: Int) {
            val parentAmount = (amount * 0.1).toInt()
            this.amount += amount -(parentAmount)
            this.parent?.reward(parentAmount)
        }
    }
}