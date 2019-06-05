package fizz_buzz;

public class FizzBuzz {
    public String say(Integer number) {
        if(isAFizzNumber(number)){
            return "Fizz";
        }
        if (isABuzzNumber(number)) {
            return "Buzz";
        }
        return number.toString();
    }

    private boolean isABuzzNumber(Integer number) {
        return number % 5 == 0;
    }

    private boolean isAFizzNumber(Integer number) {
        return number % 3 == 0;
    }
}
