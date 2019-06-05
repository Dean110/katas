package fizz_buzz;

public class FizzBuzz {
    public String say(Integer number) {
        if(isAFizzNumber(number)){
            return "Fizz";
        }
        return number.toString();
    }

    private boolean isAFizzNumber(Integer number) {
        return number == 3;
    }
}
