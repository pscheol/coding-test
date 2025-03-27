import java.util.*


class BestAlbum {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {

        return genres.indices
            .map { i -> Music(genres[i], plays[i], i) }
            .groupBy { it.genre }
            .mapValues { (_, songs) ->
                songs.sortedWith(compareByDescending<Music> { it.playCount } // 재생 수 내림차순
                    .thenBy { it.no })
                    .take(2) // 상위 2개 곡 선택
            }
            .toList()
            .sortedByDescending { (_, songs) -> songs.sumOf { it.playCount } } // 장르별 총 재생 수 기준 정렬
            .flatMap { it.second }
            .map { it.no }
            .toIntArray()
    }

    data class Music(
        val genre: String,
        val playCount: Int,
        val no: Int
    )
    data class Song(
        val no: Int,
        val play: Int,
    ) : Comparable<Song> {
        override fun compareTo(other: Song): Int {
            val playCompare = play.compareTo(other.play) * -1
            return if (playCompare != 0) playCompare else no.compareTo(other.no)
        }
    }
    data class Genre(
        var total: Int = 0,
        val songs: SortedSet<Song> = sortedSetOf(),
    ) {
        fun addSong(no: Int, play: Int) {
            total+= play
            songs.add(Song(no, play))
        }
    }
}