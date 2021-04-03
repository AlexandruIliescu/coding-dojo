import static codingDojo.FizzBuzz.gameValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    @Test
    void testGameValueOf0is0() {
        assertThat(gameValue(0), is("0"));
    }

    @Test
    void testGameValueOf1is1() {
        assertThat(gameValue(1), is("1"));
    }

    @Test
    void testGameValueOf2is2() {
        assertThat(gameValue(2), is("2"));
    }

    @Test
    void testGameValueOf3isFizz() {
        assertThat(gameValue(3), is("Fizz"));
    }

    @Test
    void testGameValueOf5isBuzz() {
        assertThat(gameValue(5), is("Buzz"));
    }

    @Test
    void testGameValueOf15isFizzBuzz() {
        assertThat(gameValue(15), is("FizzBuzz"));
    }

    @Test
    void testGameValueOf13isFizz() {
        assertThat(gameValue(13), is("Fizz"));
    }

    @Test
    void testGameValueOf25isBuzz() {
        assertThat(gameValue(25), is("Buzz"));
    }
}