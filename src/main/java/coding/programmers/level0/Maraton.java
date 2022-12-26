package coding.programmers.level0;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maraton {
    public static void main(String[] args) {
        String[] s = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
//        String result = solution(s,c);


        int[] ar = {1,2,3,3,3,4};
        int[] ar1 = {1,1,2,2,};
        int[] ar2 = {1};

//        System.out.println(solution(ar));
//        System.out.println(solution(ar1));
//        System.out.println(solution(ar2));
//        System.out.println((char)97);
//        int length = (int)Math.log10(23) + 1;
//
//        System.out.println(solution(23));
//        int[] ara = {1, 2, 3, 4, 5, 6, 7};
//        int[] result = solution(ara);
//        System.out.println(Arrays.toString(result));
//        int n = 100;
//        System.out.println("count "+ IntStream.rangeClosed(1, n).filter(v -> n % v == 0).count());
//        for (int i = 1; i <= 20; i++) {
//            if (20 % i ==0) {
//                System.out.println(i);
//            }
//        }
        Map<String, String> MORSE = Stream.of(new String[][] {
                {".-","a"},{"-...","b"},{"-.-.","c"},{"-..","d"},{".","e"},{"..-.","f"}, {"--.","g"}
                ,{"....","h"},{"..","i"},{".---","j"},{"-.-","k"},{".-..","l"},
                {"--","m"},{"-.","n"},{"---","o"},{".--.","p"},{"--.-","q"},{".-.","r"},
                {"...","s"},{"-","t"},{"..-","u"},{"...-","v"},{".--","w"},{"-..-","x"},
                {"-.--","y"},{"--..","z"}}).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        int hp = 23;
        int cnt = 0;
        for (int i = 5 ; i >= 1; i-=2) {
            cnt += (hp / i);
            if ((hp %= i) == 0) {
                break;
            }
        }
        System.out.println(cnt);
        String rsp = "205";
        Map<String, String> SOL = Stream.of(new String[][] {
                        {"2","0"},{"0","5"},{"5","2"}})
                .collect(Collectors.toMap(data -> data[0], data -> data[1]));
        StringBuilder answer = new StringBuilder();
        for (char ch : rsp.toCharArray()) {
            answer.append(SOL.get(String.valueOf(ch)));
        }
        System.out.println(answer);


        String letter = ".... . .-.. .-.. ---";
        String[] split = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : split) {
            sb.append(MORSE.get(str));
        }
        System.out.println(sb.toString());



    }
    public int solution(int balls, int share) {
        BigInteger bigBalls = new BigInteger(String.valueOf(balls));
        BigInteger bigShare = new BigInteger(String.valueOf(share));
        return fac(bigBalls).divide(fac(bigBalls.subtract(bigShare)).multiply(fac(bigShare))).intValue();
    }
    public BigInteger fac(BigInteger src) {
        if (src.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        }
        return src.multiply(fac(src.subtract(BigInteger.ONE)));
    }
    /**
     * 1 2 3 4 5
     * 1 2 3
     *
     * *
     * * * * * *
     * @param emergency
     * @return
     */
    public static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            int e = emergency[i];
            int order = 1;
            for (int j = 0; j < emergency.length; j++) {
                if (e < emergency[j]) {
                    order++;
                }
            }
            answer[i] = order;
        }
        return answer;
    }
    public static String solution(int age) {
        int num = age;
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append((char)(97+ (num % 10)));
            num /= 10;
        }
        return sb.reverse().toString();
    }
    public int solution4(int price) {
        double sales = 1.0;
        if (price >= 100000 && price < 300000) {
            sales = 0.9;
        } else if (price >= 300000 && price < 500000) {
            sales = 0.7;
        } else if (price >= 500000) {
            sales = 0.5;
        }
        return (int) (price * sales);
    }
    public int solution2(int[] sides) {
        int max = sides[sides.length - 1];
        int sum = 0;
        for (int i = 0 ; i < sides.length; i++) {
            int d = sides[i];
            if (d < max) {
                sum += d;
            }
        }
        return max < sum ? 1 : 2;
    }
    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
    public String solution(String my_string, int n) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {

        }
        return answer;
    }

    public static int[] sol(int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i<= n; i++) {
            if (i % 2 != 0) {
                answer.add(i);
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int solutio4n(int[] array) {
        int answer = 0;
        int[] boxes = new int[1000 + 1];

        for (int j : array) {
            boxes[j]++;
        }

        int max = -1;
        for (int i = 0; i < boxes.length; i++) {
            if (max < boxes[i]) {
                max = boxes[i];
                answer = i;
            }
        }

        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == max) {
                count++;
            }
        }
        return count > 1 ? -1 : answer;
    }


    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String p : completion) {
            map.put(p, map.get(p) - 1);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 0) {
                answer = e.getKey();
                break;
            }
        }
        return answer;
    }
    public int solution1(int[] numbers) {
        int answer = 0;
        List<Integer> nums = Arrays.stream(numbers).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        answer = nums.get(0) * nums.get(1);
        return answer;
    }

    public static int solution3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(nums.length / 2, set.size());
    }
}
