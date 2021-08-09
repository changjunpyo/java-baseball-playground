package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split() {
        String[] got1 = "1,2".split(",");
        String[] wanted1 = {"1", "2"};
        assertThat(got1).isEqualTo(wanted1);

        String[] got2 = "1".split(",");
        String[] wanted2 = {"1"};
        assertThat(got2).isEqualTo(wanted2);
    }
    @Test
    void substring(){
        String substr = "(1,2)".substring(1, 4);
        assertThat(substr).isEqualTo("1,2");
    }
    @Test
    void charAt(){
        char first = "abc".charAt(0);
        assertThat(first).isEqualTo('a');
    }

    @Test
    @DisplayName("인덱스의 범위가 실제 문자열 길이를 벗어날때 StringIndexOutOfBoundsException이 발생한다")
    void charAt_2(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3)
                ).withMessageMatching("String index out of range: \\d+");
    }

}
