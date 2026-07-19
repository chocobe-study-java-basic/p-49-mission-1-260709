package com.github.chocobe.homework;

public class Calc {
    public Calc() {
        System.out.println("Calc 인스턴스 생성 완료");
    }

    public int run(String eval) {
        String[] words = eval.split(" ");
        int result = Integer.parseInt(words[0]);

        for (int i = 1; i < words.length; i += 2) {
            String operator = words[i];
            int operand = Integer.parseInt(words[i + 1]);

            switch (operator) {
                case "+" -> result += operand;
                case "-" -> result -= operand;
                case "*" -> result *= operand;
            }
        }

        return result;
    }
}
