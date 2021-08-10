package study;

public class StringCalculator {

  public int add(int a, int b) {
    return a + b;
  }

  public int minus(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public int divide(int a, int b) {
    return a / b;
  }

  public int calculateString(String str) {
    String[] values = str.split(" ");

    if (values.length == 0) return 0;

    int sum = Integer.parseInt(values[0]);

    for (int i = 1; i < values.length - 1; i += 2) {
      int val = Integer.parseInt(values[i + 1]);

      if (values[i].equals("+")) sum = add(sum, val);
      if (values[i].equals("-")) sum = minus(sum, val);
      if (values[i].equals("*")) sum = multiply(sum, val);
      if (values[i].equals("/")) sum = divide(sum, val);
    }
    return sum;
  }
}
