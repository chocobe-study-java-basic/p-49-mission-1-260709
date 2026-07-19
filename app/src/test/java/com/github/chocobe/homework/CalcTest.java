package com.github.chocobe.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalcTest {
    private Calc calc;

    @BeforeEach
    void initCalc() {
        this.calc = new Calc();
    }

    @Test
    @DisplayName("1 + 1 == 2")
    void t1() {
        assertThat(this.calc.run("1 + 1")).isEqualTo(2);
    }

    @Test
    @DisplayName("2 + 1 == 3")
    void t2() {
        assertThat(this.calc.run("2 + 1")).isEqualTo(3);
    }

    @Test
    @DisplayName("2 + 2 == 4")
    void t3() {
        assertThat(this.calc.run("2 + 2 == 4")).isEqualTo(4);
    }

    @Test
    @DisplayName("1000 + 280 == 1280")
    void t4() {
        assertThat(this.calc.run("1000 + 280 == 1280"));
    }

    @Test
    @DisplayName("2 - 1 == 1")
    void t5() {
        assertThat(this.calc.run("2 - 1 == 1")).isEqualTo(1);
    }
}