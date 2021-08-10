package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new StringCalculator();
    }

    @Test
    void add(){
        int got = calculator.add(1,2);
        assertThat(got).isEqualTo(3);

        got = calculator.add(10000,-10000);
        assertThat(got).isEqualTo(0);
    }

    @Test
    void minus(){
        int got = calculator.minus(1, 2);
        assertThat(got).isEqualTo(-1);

        got = calculator.minus(1000, -1000);
        assertThat(got).isEqualTo(2000);
    }

    @Test
    void multiply(){
        int got = calculator.multiply(4, 50);
        assertThat(got).isEqualTo(200);

        got = calculator.multiply(10, -10);
        assertThat(got).isEqualTo(-100);
    }

    @Test
    void divide(){
        int got = calculator.divide(20, 4);
        assertThat(got).isEqualTo(5);

        got = calculator.divide(10, 4);
        assertThat(got).isEqualTo(2);

        Assertions.assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() ->
                        calculator.divide(10, 0))
        .withMessageMatching("/ by zero");
    }

    @Test
    void stringCalculate(){
        String str = "2 + 3 * 4 / 2";
        int got = calculator.calculateString(str);
        assertThat(got).isEqualTo(10);
    }
}
