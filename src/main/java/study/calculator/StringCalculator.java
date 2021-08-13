package study.calculator;

import java.util.function.BinaryOperator;

public class StringCalculator {


    public int calculate(String str) {
        validateInput(str);
        return calculateValues(str.split(" "));
    }

    private void validateInput(String str) {
        if (str.isEmpty() || str == null) {
            throw new IllegalArgumentException("입력은 공백이 아니여야 합니다");
        }
    }

    private int calculateValues(String[] values) {

        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length - 1; i += 2) {
            int operand = Integer.parseInt(values[i + 1]);
            BinaryOperator<Integer> binaryOperator = Operation.getBinaryOperator(values[i]);
            result = binaryOperator.apply(result, operand);
        }
        return result;
    }

}
