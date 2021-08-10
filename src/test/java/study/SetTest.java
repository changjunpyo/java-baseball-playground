package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("SET의 초기 사이즈는 3이다")
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("set은 {1,2,3}을 포함하고 있다")
  void contains(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(
      value = {"1:true", "2:true", "3:true", "4:false", "5:false"},
      delimiter = ':')
  @DisplayName("set은 1,2,3을 포함하고 4,5는 포함하고 있지 않다")
  void contains(String input, String expected) {
    Integer i = Integer.getInteger(input);
    Boolean o = Boolean.getBoolean(expected);
    assertThat(numbers.contains(i)).isEqualTo(o);
  }
}
