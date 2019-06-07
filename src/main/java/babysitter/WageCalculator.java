package babysitter;

public class WageCalculator {
    public int calculateShiftWage(int startingHour, int endingHour, int bedtime) {
        if (startingTimeIsInvalid(startingHour))
            throw new InvalidStartTimeException(startingHour);
        if (!(endingHour <= 4 || endingHour >= 17)) throw new InvalidEndTimeException(endingHour);
        return 12;
    }

    private boolean startingTimeIsInvalid(int startingHour) {
        return startingHour < 17;
    }

    protected class InvalidStartTimeException extends RuntimeException {

        public InvalidStartTimeException(int startTime) {

            super(startTime + " is an invalid start time for a babysitter shift.");
        }

    }

    protected class InvalidEndTimeException extends RuntimeException {
        public InvalidEndTimeException(int endingTime) {
            super(endingTime + " is an invalid end time for a babysitter shift.");
        }
    }
}
