package com.github.chocobe.lecture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("테스트 할 수 있다.")
    public void test1() {
        System.out.println("test1");
    }

    @Test
    @DisplayName("plus 함수 구현")
    public void t2() {
        Calculator calculator = new Calculator();
        calculator.plus(1, 2);
    }

    @Test
    @DisplayName("plus 함수 1 + 2 테스트")
    public void t3() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("plus 함수 4 + 6 테스트")
    public void t4() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(4, 6);
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("plus 함수 10 + 20 테스트")
    public void t5() {
        Calculator calculator = new Calculator();
        int result = calculator.plus(10, 20);
        assertThat(result).isEqualTo(30);
    }
}
