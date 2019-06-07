package babysitter;

public class WageCalculator {
    public int calculateShiftWage(int startingHour, int endingHour, int bedtime) {
        if (startingTimeIsInvalid(startingHour))
            throw new InvalidStartTimeException(startingHour);
        if (endingTimeIsInvalid(endingHour))
            throw new InvalidEndTimeException(endingHour);
        if(shiftIsInvalid(startingHour, endingHour))
            throw new InvalidTimePunchesException();
        return 12;
    }

    private boolean shiftIsInvalid(int startingHour, int endingHour) {
        return startingHour>=endingHour;
    }

    private boolean startingTimeIsInvalid(int startingHour) {
        return startingHour < 17;
    }

    private boolean endingTimeIsInvalid(int endingHour) {
        return endingHour > 4 && endingHour < 18;
    }

}
