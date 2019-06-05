package fizz_buzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Here are the rules for this kata:
 * <p>
 * -Write a method that takes an integer and returns a string. This represents the act of saying a number.
 * -The string should be the numerical characters that represent the value of the integer that was passed, EXCEPT:
 * -When the integer passed is a multiple of 3, the method should say Fizz.
 * -When the integer passed is a multiple of 5, the method should say Buzz.
 */
public class FizzBuzzTest {

    private FizzBuzz underTest;

    private void assertSpokenWord(int number, String expectedSpeech) {
        String spokenWord = underTest.say(number);
        assertThat(spokenWord, is(expectedSpeech));
    }

    @Before
    public void setup() {
        underTest = new FizzBuzz();
    }

    @Test
    public void whenGiven1FizzBuzzSays1() {
        assertSpokenWord(1, "1");
    }

    @Test
    public void whenGiven2FizzBuzzSays2() {
        assertSpokenWord(2, "2");
    }

    @Test
    public void whenGiven3FizzBuzzSaysFizz() {
        assertSpokenWord(3, "Fizz");
    }

    @Test
    public void whenGiven5FizzBuzzSaysBuzz() {
        assertSpokenWord(5, "Buzz");
    }


    @Test
    public void whenGiven6FizzBuzzSaysFizz(){
        assertSpokenWord(6,"Fizz");
    }

    @Test
    public void whenGiven10FizzBuzzSaysBuzz(){
        assertSpokenWord(10, "Buzz");
    }

    @Test
    public void whenGiven15FizzBuzzSaysFizzBuzz(){
        assertSpokenWord(15, "FizzBuzz");
    }
}
