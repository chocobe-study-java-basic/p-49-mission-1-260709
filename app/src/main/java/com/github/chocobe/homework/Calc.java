package com.github.chocobe.homework;

import java.util.ArrayList;
import java.util.List;

/*
TODO: 리스트 가공 연습 필요
    - 리스트 중간 요소 수정하기
    - 리스트 중간 요소 n개 삭제하기
    - 리스트 중간에 요소 n개 추가하기
    - 리스트에서 특정 요소의 index 찾기
 */

public class Calc {
    /*
    - `flatEval()` 메소드와 순환 함수
     */
    public int run(String eval) {
        String flattenedEval = eval;

        while (flattenedEval.contains("(")) {
            flattenedEval = this.flatEval(flattenedEval);
        }

        List<String> words = new ArrayList<>(List.of(flattenedEval.split(" ")));

        while (words.size() > 2) {
            int indexOfOperator = 1;
            for (int i = 1; i < words.size(); i += 2) {
                String operator = words.get(i);

                if (operator.equals("*") || operator.equals("/")) {
                    indexOfOperator = i;
                    break;
                }
            }

            int num1 = Integer.parseInt(words.get(indexOfOperator - 1));
            int num2 = Integer.parseInt(words.get(indexOfOperator + 1));
            String operator = words.get(indexOfOperator);

            switch (operator) {
                case "+" -> num1 += num2;
                case "-" -> num1 -= num2;
                case "*" -> num1 *= num2;
            }

            List<String> forwardList = words.subList(0, indexOfOperator);
            forwardList.set(forwardList.size() - 1, num1 + "");
            List<String> backwardList = words.subList(indexOfOperator + 2, words.size());

            forwardList.addAll(backwardList);
            words = new ArrayList<>(forwardList);
        }

        return Integer.parseInt(words.getFirst());
    }

    /*
    괄호가 있으면 평탄화 해서 문자열로 반환
    - `run()` 메소드와 순환 호출
     */
    private String flatEval(String eval) {
        int indexOfStart = eval.indexOf("(");
        if (indexOfStart < 0) {
            return eval;
        }

        int numOfPairs = 1;
        int indexOfEnd = -1;

        for (int i = indexOfStart + 1; i < eval.length(); i++) {
            if (eval.charAt(i) == '(') {
                numOfPairs++;
                continue;
            }

            if (eval.charAt(i) == ')') {
                indexOfEnd = i;
                numOfPairs--;

                if (numOfPairs == 0) {
                    break;
                }
            }
        }

        String subEval = eval.substring(indexOfStart + 1, indexOfEnd);
        String flatted = this.run(subEval) + "";

        StringBuilder sb = new StringBuilder(eval);
        sb.replace(indexOfStart, indexOfEnd + 1, flatted);

        return sb.toString();
    }
}
