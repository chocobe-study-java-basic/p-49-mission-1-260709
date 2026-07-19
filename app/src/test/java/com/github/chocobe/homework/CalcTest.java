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
}