package com.github.chocobe.homework;

import java.util.Arrays;

public class Calc {
    public Calc() {
        System.out.println("Calc 인스턴스 생성 완료");
    }

    public int run(String eval) {
        String[] words = eval.split(" ");
        System.out.println(Arrays.asList(words));

        int num1 = Integer.parseInt(words[0]);
        int num2 = Integer.parseInt(words[2]);

        return num1 + num2;
    }
}
