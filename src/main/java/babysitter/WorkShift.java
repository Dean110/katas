package babysitter;

public class WorkShift {
    public static final int WORKDAY_START_TIME = 5;
    private static final int MIDNIGHT = 24;
    private int startingHour;
    private int endingHour;
    private int bedtime;

    private int preBedtimePreMidnightHours;
    private int postBedtimePreMidnightHours;
    private int postMidnightHours;

    public WorkShift(int startingHour, int endingHour, int bedtime) {

        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.bedtime = bedtime;

        calculateShiftSegments();
    }

    private void calculateShiftSegments() {
        shiftTimesToBeRelativeToStartOfWorkDay();

        calculatePreBedTimePreMidnightHours();
        calculatePostBedTimePremidnightHours();
        calculatePostMidnightHours();
    }

    private void shiftTimesToBeRelativeToStartOfWorkDay() {
        startingHour = shiftToBeRelativeToTheStartOfTheWorkday(startingHour);
        endingHour = shiftToBeRelativeToTheStartOfTheWorkday(endingHour);
        bedtime = shiftToBeRelativeToTheStartOfTheWorkday(bedtime);
    }

    private int shiftToBeRelativeToTheStartOfTheWorkday(int punchHour) {
        int shiftedHour = punchHour;
        if (shiftedHour < WORKDAY_START_TIME) {
            return shiftedHour + 24;
        } else
            return shiftedHour;
    }

    private void calculatePreBedTimePreMidnightHours() {
        preBedtimePreMidnightHours = 0;
        if (shiftHasPreBedTimeHours() && shiftBeginsBeforeMidnight()) {
            if (shiftEndsAfterBedtime()) {
                preBedtimePreMidnightHours = bedtime - startingHour;
            } else {
                preBedtimePreMidnightHours = endingHour - startingHour;
            }
        }
    }

    private void calculatePostBedTimePremidnightHours() {
        postBedtimePreMidnightHours = 0;
        if (shiftEndsAfterBedtime() && shiftBeginsBeforeMidnight()) {
            int segmentStartingHour;
            if (shiftBeginsAfterBedtime()) {
                segmentStartingHour = startingHour;
            } else {
                segmentStartingHour = bedtime;
            }
            int segmentEndingHour;
            if (shiftEndsBeforeMidnight()) {
                segmentEndingHour = endingHour;
            } else {
                segmentEndingHour = MIDNIGHT;
            }
            postBedtimePreMidnightHours = segmentEndingHour - segmentStartingHour;
        }
    }

    private void calculatePostMidnightHours() {
        postMidnightHours = 0;
        if (!shiftEndsBeforeMidnight()) {
            int segmentStartingHour;
            if (shiftBeginsBeforeMidnight()) {
                segmentStartingHour = MIDNIGHT;
            } else {
                segmentStartingHour = startingHour;
            }
            postMidnightHours = endingHour - segmentStartingHour;
        }
    }

    private boolean shiftHasPreBedTimeHours() {
        return startingHour < bedtime;
    }

    private boolean shiftBeginsBeforeMidnight() {
        return startingHour < MIDNIGHT;
    }

    private boolean shiftEndsBeforeMidnight() {
        return endingHour < MIDNIGHT;
    }

    private boolean shiftBeginsAfterBedtime() {
        return startingHour > bedtime;
    }

    private boolean shiftEndsAfterBedtime() {
        return endingHour > bedtime;
    }

    public int getPreBedtimePreMidnightHours() {
        return preBedtimePreMidnightHours;
    }

    public int getPostBedtimePreMidnightHours() {
        return postBedtimePreMidnightHours;
    }

    public int getPostMidnightHours() {
        return postMidnightHours;
    }
}
