package com.coding.programmers.level3;

import java.util.*;
import java.util.stream.Stream;

public class 베스트앨범 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(result));

        int[] result2 = sol.solution(new String[]{"classic", "pop", "classic", "classic"}, new int[]{800, 600, 150, 800});
        System.out.println(Arrays.toString(result2));
    }

    private static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();

            Map<String, Genre> map = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                Genre genre = map.getOrDefault(genres[i], new Genre());
                genre.addItem(i, plays[i]);
                map.put(genres[i], genre);
            }

            map.entrySet().stream()
                    .sorted(((o1, o2) -> Integer.compare(o1.getValue().total, o2.getValue().total) * -1))
                    .forEach(entry -> {
                        SortedSet<Song> songs = entry.getValue().songs;
                        Iterator<Song> songIterator = songs.iterator();
                        int cnt = 0;
                        while (songIterator.hasNext() && cnt < 2) {
                            answer.add(songIterator.next().no);
                            cnt++;
                        }
                    });

            return answer.stream().mapToInt((i) ->i).toArray();
        }
        private static class Song implements Comparable<Song> {
            private final int no;
            private final int play;

            public Song(int no, int play) {
                this.no = no;
                this.play = play;
            }

            @Override
            public int compareTo(Song o) {
                int compare = Integer.compare(play, o.play) * -1;
                return compare != 0 ? compare : Integer.compare(this.no, o.no);
            }
        }

        private static class Genre {
            private int total;
            private final SortedSet<Song> songs;

            public Genre() {
                this.total = 0;
                songs = new TreeSet<>();
            }

            public void addItem(int no, int play) {
                this.total += play;
                songs.add(new Song(no ,play));
            }
        }
    }

    private static class Solution2 {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, List<int[]>> genreMap = new HashMap<>();
            Map<String, Integer> playMap = new HashMap<>();

            //1. 장르별 총 재생 횟수, 곡 재생 횟수 저장
            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int play = plays[i];
                List<int[]> songs = genreMap.getOrDefault(genre, new ArrayList<>());
                songs.add(new int[]{i, play});
                genreMap.put(genre, songs);
                playMap.put(genre, playMap.getOrDefault(genre, 0) + play);
            }

            //2. 총 재생횟수가 많은 순으로 정렬
            Stream<Map.Entry<String, Integer>> genreStream = playMap.entrySet()
                    .stream()
                    .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));


            List<Integer> answer = new ArrayList<>();
            genreStream.forEach(entry -> {
                Stream<int[]> songs = genreMap.get(entry.getKey())
                        .stream()
                        .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                        .limit(2);
                songs.forEach(v -> {
                    answer.add(v[0]);
                });
            });

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
