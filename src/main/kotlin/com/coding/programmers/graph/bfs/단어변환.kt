package com.coding.programmers.graph.bfs

import java.util.ArrayDeque

fun main() {
    val r= 단어변환().solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
    println(r)
}

/**
 * 한 번에 한 개의 알파벳만 바꿀 수 있다.
 * words에 있는 단어로만 변환 가능
 */
class 단어변환 {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val queue = ArrayDeque<Node>()
        val dist = HashSet<String>()

        queue.add(Node(begin, 0))
        dist.add(begin)

        while(queue.isNotEmpty()) {
            val dq = queue.poll();

            if (dq.word == target) {
                answer = dq.weight
                break;
            }

            for (word in words) {
                if (!dist.contains(word) && dq.compareWith(word)) {
                    queue.offer(Node(word, dq.weight + 1))
                    dist.add(word)
                }
            }
        }

        return answer
    }
    data class Node(
        val word: String,
        val weight: Int,
    ) {
        fun compareWith(target: String): Boolean {
            var count = 0

            for (i in word.indices) {
                if (word[i] != target[i] && ++count > 1) {
                    break
                }
            }
            return count == 1
        }
    }
}