fun main() {
//    FailRate().solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3))
//    println(방문길이().solution("ULURRDLLU"))
//    println(NumberToBinary().solution(10))
//    println(OXQuiz().solution(arrayOf("3 - 4 = -3", "5 + 6 = 11")).contentToString())
//    println(Couple().solution("baabaa"))
//    println(Couple().solution("cdcd"))

//    println(StockPrice().solution(arrayOf(1,2,3,2,3)).contentToString())
//    println(CrainDoolGame().solution(
//        board = arrayOf<IntArray>(
//            intArrayOf(0, 0, 0, 0, 0),
//            intArrayOf(0, 0, 1, 0, 3),
//            intArrayOf(0, 2, 5, 0, 1),
//            intArrayOf(4, 2, 4, 4, 2),
//            intArrayOf(3, 5, 1, 3, 1)
//        ),
//        moves = intArrayOf(1,5,3,5,1,2,1,4)
//    ))
//    println(solution(8,4,7))
//    val result = FindRoad().solution(arrayOf(
//        intArrayOf(5,3),
//        intArrayOf(11,5),
//        intArrayOf(13,3),
//        intArrayOf(3,5),
//        intArrayOf(5,1),
//        intArrayOf(1,3),
//        intArrayOf(8,6),
//        intArrayOf(7,2),
//        intArrayOf(2,2),
//    ))
//
//    println(result.contentToString())

//    val n = 5
//    val parent: IntArray = IntArray(n) { it }
//
//    println(parent.contentToString())


//    println(UnionFind().solution(
//        3, arrayOf(
//            intArrayOf(0, 0, 1),
//            intArrayOf(0, 1, 2),
//            intArrayOf(1, 1, 2),
//        )
//    ).contentToString())


//    println(DFS().solution(
//        arrayOf(
//            intArrayOf(1,2),
//            intArrayOf(1,3),
//            intArrayOf(2,4),
//            intArrayOf(2,5),
//            intArrayOf(3,6),
//            intArrayOf(5,6),
//        ),
//        1, 6
//    ).contentToString())
//
//    println(BFS().solution(
//        arrayOf(
//            intArrayOf(1,2),
//            intArrayOf(1,3),
//            intArrayOf(2,4),
//            intArrayOf(2,5),
//            intArrayOf(3,6),
//            intArrayOf(3,7),
//            intArrayOf(4,8),
//            intArrayOf(5,8),
//            intArrayOf(6,9),
//        ),
//        1, 9
//    ).contentToString())
//
//    println(BFS().solution(
//        arrayOf(
//            intArrayOf(1,3),
//            intArrayOf(3,4),
//            intArrayOf(3,5),
//            intArrayOf(5,2),
//        ),
//        1, 5
//    ).contentToString())

//
//    println(Dijkstra().solution(
//        arrayOf(
//            intArrayOf(0, 1, 9),
//            intArrayOf(0, 2, 3),
//            intArrayOf(1, 0, 5),
//            intArrayOf(2, 1, 1),
//        ),
//        0, 3
//    ).contentToString())
//
//
//    println(Dijkstra().solution(
//        arrayOf(
//            intArrayOf(0, 1, 1),
//            intArrayOf(1, 2, 5),
//            intArrayOf(2, 3, 1),
//        ),
//        0, 4
//    ).contentToString())

//
//    println(GameMap().solution(
//        arrayOf(
//            intArrayOf(1, 0, 1, 1, 1),
//            intArrayOf(1, 0, 1, 0, 1),
//            intArrayOf(1, 0, 1, 1, 1),
//            intArrayOf(1, 1, 1, 0, 1),
//            intArrayOf(0, 0, 0, 0, 1),
//        )
//    ))
//
//    println(Network().solution(
//        3,
//        arrayOf(
//            intArrayOf(1,1,0),
//            intArrayOf(1,1,0),
//            intArrayOf(0,0,1),
//        )
//    ))
//
//    println(Miro().solution(
//        arrayOf(
//            "SOOOL",
//            "XXXXO",
//            "OOOOO",
//            "OXXXX",
//            "OOOOE",
//        )
//    ))
//
//    println(Miro().solution(
//        arrayOf(
//            "LOOXS",
//            "OOOOX",
//            "OOOOO",
//            "OOOOO",
//            "EOOOO",
//        )
//    ))

//    println(Delivery().solution(5,
//        arrayOf(
//            intArrayOf(1,2,1),
//            intArrayOf(2,3,3),
//            intArrayOf(5,2,2),
//            intArrayOf(1,4,2),
//            intArrayOf(5,3,1),
//            intArrayOf(5,4,2),
//        ),
//        3))
//
//    println(RoadBuild().solution(
//        arrayOf(
//            intArrayOf(0,0,0,0,0,0,0,1),
//            intArrayOf(0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,1,0,0),
//            intArrayOf(0,0,0,0,1,0,0,0),
//            intArrayOf(0,0,0,1,0,0,0,1),
//            intArrayOf(0,0,1,0,0,0,1,0),
//            intArrayOf(0,1,0,0,0,1,0,0),
//            intArrayOf(1,0,0,0,0,0,0,0)
//        )
//    ))

//    println(SeparateElectric().solution(9,
//        arrayOf(
//            intArrayOf(1,3),
//            intArrayOf(2,3),
//            intArrayOf(3,4),
//            intArrayOf(4,5),
//            intArrayOf(4,6),
//            intArrayOf(4,7),
//            intArrayOf(7,8),
//            intArrayOf(7,9),
//        )
//        ))

//    println(가장먼노드().solution(6, arrayOf(
//        intArrayOf(3,6),
//        intArrayOf(4,3),
//        intArrayOf(3,2),
//        intArrayOf(1,3),
//        intArrayOf(1,2),
//        intArrayOf(2,4),
//        intArrayOf(5,2),
//    )))

//    val result = Backtracking().solution(5)
//    for (ints in result) {
//        println(ints.contentToString())
//    }
//    BooleanArray(5)
//
//    val result = Sudoku().solution(
//        arrayOf(
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//            intArrayOf(0,0,0,0,0,0,0,0,0),
//        )
//    )
//    for (ints in result) {
//        println(ints.contentToString())
//    }

//    println(NQueen().solution(4))
//    양궁대회().start()
//    귤고르기().solution(6, intArrayOf(1,3,2,5,4,5,2,3))
//    택배상자꺼내기().start()
//    유연근무제().start()



    val numlist = intArrayOf(3,4,5,2,1)
    val sum = numlist.sum()
    val mul = numlist.reduce { acc, i -> acc * i }
    println(sum * sum)
    println(mul)
    val evenSum: Int = numlist.filter { it % 2 == 0}.fold("") { acc: String, i:Int -> "$acc$i"}.toInt()
    val oddSum: Int = numlist.filter { it % 2 != 0}.fold("") { acc: String, i:Int -> "$acc$i"}.toInt()
}



fun solution(n: Int, a: Int, b: Int): Int {
    var a = a
    var b = b
    var answer = 0
    while (a != b) {
        a = (a + 1) / 2
        b = (b + 1) / 2
        answer++
    }
    return answer
}
class Solution {
    var answer = -1
    private lateinit var dungeonsArr: Array<IntArray>
    private lateinit var visited: BooleanArray

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        this.dungeonsArr = dungeons.copyOf()
        this.visited = BooleanArray(dungeons.size)
        fatigue(k, 0)
        return answer
    }

    fun fatigue(energy: Int, count: Int) {
        for (i: Int in dungeonsArr.indices) {
            if (!visited[i] && dungeonsArr[i][0] <= energy) {
                visited[i] = true
                fatigue(energy - dungeonsArr[i][0], count + 1)
                answer = Math.max(answer, count + 1)
                visited[i] = false
            }
        }
    }
}