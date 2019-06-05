package fizz_buzz;

public class FizzBuzz {
    public String say(Integer number) {
        if(isAFizzNumber(number)){
            return "Fizz";
        }
        if(number ==5){
            return "Buzz";
        }
        return number.toString();
    }

    private boolean isAFizzNumber(Integer number) {
        return number == 3;
    }
}
