package com.github.chocobe.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calc {
    public Calc() {
        System.out.println("Calc 인스턴스 생성 완료");
    }

    // TODO: 리스트 가공 연습 필요
    // - 리스트 중간 요소 수정하기
    // - 리스트 중간 요소 n개 삭제하기
    // - 리스트 중간에 요소 n개 추가하기
    // - 리스트에서 특정 요소의 index 찾기
    public int run(String eval) {
        // FIXME: 1. 불변성 List 사용으로 UnsupportedOperator 에러 발생
        // List<String> words = Arrays.asList(eval.split(" "));

        // NOTE: 변경 가능 List 사용
        List<String> words = new ArrayList<>(Arrays.stream(eval.split(" ")).toList());

        while (words.size() > 2) {
            // FIXME: 2. "*" 의 index 추출 실패
            // int indexOfOperator = words.stream()
            //         .filter(v -> v.equals("*"))
            //         .findFirst()
            //         .map(Integer::parseInt)
            //         .orElse(1);

            // int indexOfOperator = words.indexOf("*");
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

            // FIXME: 실패 1 - 불변성 List 에 변경 시도함
            // words.subList(indexOfOperator, indexOfOperator + 2).clear();
            // words.set(indexOfOperator - 1, num1 + "");

            // FIXME: 실패2 - 실패 확인 중
            // List<String> subList = words.subList(indexOfOperator, indexOfOperator + 2);
            // subList.clear();
            //
            // words.set(indexOfOperator - 1, num1 + "");

            List<String> forwardList = words.subList(0, indexOfOperator);
            forwardList.set(forwardList.size() - 1, num1 + "");
            List<String> backwardList = words.subList(indexOfOperator + 2, words.size());

            forwardList.addAll(backwardList);
            words = new ArrayList<>(forwardList);
        }

        return Integer.parseInt(words.getFirst());
    }

    // NOTE: t15 실패
    // public int run(String eval) {
    //     String[] words = eval.split(" ");
    //     int result = Integer.parseInt(words[0]);
    //
    //     for (int i = 1; i < words.length; i += 2) {
    //         String operator = words[i];
    //         int operand = Integer.parseInt(words[i + 1]);
    //
    //         switch (operator) {
    //             case "+" -> result += operand;
    //             case "-" -> result -= operand;
    //             case "*" -> result *= operand;
    //         }
    //     }
    //
    //     return result;
    // }
}
