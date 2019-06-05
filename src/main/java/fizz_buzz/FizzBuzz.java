package fizz_buzz;

public class FizzBuzz {
    public String say(Integer number) {
        String spokenWord = "";

        if (isAFizzNumber(number)) {
            spokenWord += "Fizz";
        }
        if (isABuzzNumber(number)) {
            spokenWord += "Buzz";
        }
        if (isNotSubstituted(spokenWord)) {
            spokenWord += number.toString();
        }
        return spokenWord;
    }

    private boolean isAFizzNumber(Integer number) {
        return number % 3 == 0;
    }

    private boolean isABuzzNumber(Integer number) {
        return number % 5 == 0;
    }

    private boolean isNotSubstituted(String spokenWord) {
        return spokenWord.isEmpty();
    }
}
