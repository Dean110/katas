package babysitter;

public class WageCalculator {

    public static final int PREBEDTIME_PREMIDNIGHT_WAGE = 12;
    public static final int POSTBEDTIME_PREMIDNIGHT_WAGE = 8;
    public static final int POSTMIDNIGHT_WAGE = 16;

    public int calculateShiftWage(int startingHour, int endingHour, int bedtime) {
        validateShiftTimes(startingHour, endingHour);

        if(startingHour>=bedtime)
            return calculateHoursWorked(startingHour, endingHour) * POSTBEDTIME_PREMIDNIGHT_WAGE;
        if(startingHour>=0&& startingHour<4)
            return calculateHoursWorked(startingHour, endingHour) * POSTMIDNIGHT_WAGE;
        return calculateHoursWorked(startingHour, endingHour) * PREBEDTIME_PREMIDNIGHT_WAGE;
    }

    private int calculateHoursWorked(int startingHour, int endingHour) {
        return endingHour-startingHour;
    }

    private void validateShiftTimes(int startingHour, int endingHour) {
        if (startingTimeIsInvalid(startingHour))
            throw new InvalidStartTimeException(startingHour);
        if (endingTimeIsInvalid(endingHour))
            throw new InvalidEndTimeException(endingHour);
        if(shiftIsInvalid(startingHour, endingHour))
            throw new InvalidTimePunchesException();
    }

    private boolean startingTimeIsInvalid(int startingHour) {
        return startingHour < 17 && startingHour > 3;
    }

    private boolean endingTimeIsInvalid(int endingHour) {
        return endingHour > 4 && endingHour < 18;
    }

    private boolean shiftIsInvalid(int startingHour, int endingHour) {
        startingHour = convertTimeToShiftRelativeTime(startingHour);
        endingHour = convertTimeToShiftRelativeTime(endingHour);
        return startingHour>=endingHour;
    }

    private int convertTimeToShiftRelativeTime(int startingHour) {
        if (startingHour<12){
            startingHour +=24;
        }
        return startingHour;
    }

}
