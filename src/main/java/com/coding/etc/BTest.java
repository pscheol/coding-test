package com.coding.etc;


import java.util.*;
import java.util.regex.Pattern;

/**
 * · Java Stream과 Lambda, Optional 사용 여부
 * · 문자열 패턴 가공 능력
 * · 문자열 조작 능력과 Map 사용 능력
 * · Map 또는 PriorityQueue 사용 능력
 * · Countable Map 을 활용여부
 * · SQL기초
 */
public class BTest {
    public static void main(String[] args) {
//        Solution1 sol = new Solution1();
//        String result = sol.solution(new String[]{"abc", "defg", "whatever", "hello", "world", "woowabrothers", "woowabros", "baemin", "baedalminjok"});
//        System.out.println(result);
//        Solution2 sol2 = new Solution2();
//        String result2 = sol2.solution(new String[]{"a", "b", "c"}, new String[]{"b", "c", "d"});
//        System.out.println(result2);


//        Solution3 sol3 = new Solution3();
//        String[] result3 = sol3.solution(new String[]{"123456789,유기농쌀 4kg,50000", "234578882,배달이캐릭터숟가락,3000"}, new String[]{"20220810,123456789,5", "20220810,234578882,30", "20220811,123456789,7"});
//        System.out.println(Arrays.toString(result3));

        Solution4 sol4 = new Solution4();
        System.out.println(sol4.solution("/payment/1234/cancel"));
        System.out.println(sol4.solution("/payment/1234"));

//        Solution5 sol5 = new Solution5();
//        System.out.println(Arrays.toString(sol5.solution(new int[]{1})));
    }

   /* private static class Solution1 {
        public String solution(String[] params) {
            Optional<String> answer = Arrays.stream(params).map(String::toUpperCase)
                    .filter(s -> s.length() >= 5 && s.length() <= 10).findAny();

            return answer.orElse("없음");
        }
    }

    private static class Solution2 {
        public String solution(String[] leftArray, String[] rightArray) {
            Set<String> leftSet = new HashSet<>(Arrays.asList(leftArray));
            return Arrays.stream(rightArray)
                    .collect(Collectors.toSet())
                    .stream()
                    .filter(leftSet::contains)
                    .sorted()
                    .collect(Collectors.joining(","));
        }
    }*/
    private static class Solution3 {
        public String[] solution(String[] productInfo, String[] dailyProductSales) {
            String[] answer = new String[dailyProductSales.length];
            Map<String, String> productMap = parseProductInfo(productInfo);

            for (int i = 0; i < dailyProductSales.length; i++) {
                String[] dailyProductSale = dailyProductSales[i].split(",");
                String saleDate = dailyProductSale[0];
                String goodsId = dailyProductSale[1];
                int saleCount = Integer.parseInt(dailyProductSale[2]);

                String[] info = productMap.get(goodsId).split(",");
                String goodsName = info[0];
                int price = Integer.parseInt(info[1]);

                answer[i] = concatData(saleDate, goodsId, saleCount, goodsName, price);
            }
            return answer;
        }

       private String concatData(String saleDate, String goodsId, int saleCount, String goodsName, int price) {
           List<String> data = new ArrayList<>();
           data.add(saleDate);
           data.add(goodsId);
           data.add(goodsName);
           data.add(String.valueOf(saleCount * price));
           return String.join(",", data);

       }

       private Map<String, String> parseProductInfo(String[] productInfo) {
           Map<String, String> resultMap = new HashMap<>();

           for (String product : productInfo) {
               String[] info = product.split(",");
               resultMap.put(info[0], info[1] + "," + info[2]);
           }
           return resultMap;
       }
   }


    private static class Solution4 {
        public String solution(String pathVariableUrl) {
            String answer = "";


            Pattern pattern = Pattern.compile("^/+[a-zA-z]+/[0-9]{2,9}+/[a-z]+$");
            if (pattern.matcher(pathVariableUrl).matches()) {
                String[] split = pathVariableUrl.split("/");

            } else {
                answer = "error";
            }
            // 코드 작성 위치
            return answer;
        }
    }

    private static class Solution5 {
        public int[] solution(int[] card) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i : card) {
                map.put(i, map.getOrDefault(i, -1) + 1);
            }

            return map.entrySet().stream()
                    .filter(entry -> entry.getValue() == 0)
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}
