package main;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void t2() {
        Calculator calculator = new Calculator();
        calculator.plus(1, 2);
    }
}
