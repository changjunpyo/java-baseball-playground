package study.calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String operation;
    private final BinaryOperator<Integer> binaryOperator;

    Operation(String operation, BinaryOperator<Integer> binaryOperator) {
        this.operation = operation;
        this.binaryOperator = binaryOperator;
    }

    private static Operation getOperation(String operator) {
        return Arrays.stream(values())
            .filter(operations -> operations.operation.equals(operator))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

    static BinaryOperator<Integer> getBinaryOperator(String operator) {
        Operation operation = getOperation(operator);
        return operation.binaryOperator;
    }
}
