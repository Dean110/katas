package babysitter;

public class WageCalculator {
    public int calculateShiftWage(int startingHour, int endingHour, int bedtime) {
        if (startingHour == 14)
            throw new InvalidStartTimeException(startingHour + " is an invalid start time for a babysitter shift.");
        return 12;
    }

    protected class InvalidStartTimeException extends RuntimeException {

        public InvalidStartTimeException(String message) {
            super(message);
        }
    }
}
