class 영어끝말잇기 {
    fun sulution(n: Int, words: Array<String>) : IntArray {
        val duplicate: MutableSet<String> = mutableSetOf()
        var prefWord: Char = words[0][0]

        for (i in words.indices) {
            val word = words[i]
            if (duplicate.contains(word) || prefWord != word[0]) {
                return intArrayOf((i % n) + 1, (i / n) + 1)
            }
            duplicate.add(word)
            prefWord = word[word.length - 1]
        }

        return intArrayOf(0, 0)
    }
}