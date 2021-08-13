package study.calculator;

import java.util.function.BinaryOperator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add() {
        BinaryOperator<Integer> plusOperator = Operation.getBinaryOperator("+");
        int got = plusOperator.apply(1,2);
        assertThat(got).isEqualTo(3);
    }

    @Test
    void minus() {
        BinaryOperator<Integer> minusOperator = Operation.getBinaryOperator("-");
        int got = minusOperator.apply(1000, -1000);
        assertThat(got).isEqualTo(2000);
    }

    @Test
    void multiply() {
        BinaryOperator<Integer> multiplyOperator = Operation.getBinaryOperator("*");
        int got = multiplyOperator.apply(40, 30);
        assertThat(got).isEqualTo(1200);
    }

    @Test
    void divide() {
        BinaryOperator<Integer> divideOperator = Operation.getBinaryOperator("/");
        int got = divideOperator.apply(20, 4);
        assertThat(got).isEqualTo(5);

        got = divideOperator.apply(10, 4);
        assertThat(got).isEqualTo(2);

        Assertions.assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> divideOperator.apply(10,0))
            .withMessageMatching("/ by zero");
    }

    @Test
    void stringCalculate() {
        String str = "2 + 3 * 4 / 2";
        int got = stringCalculator.calculate(str);
        assertThat(got).isEqualTo(10);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 - 6 * 4 / 3:-2", "6 / 3 + 2 - 10:-6"}, delimiter = ':')
    void 사칙연산_테스트(String str, int expected) {
        int got = stringCalculator.calculate(str);
        assertThat(got).isEqualTo(expected);
    }
}
