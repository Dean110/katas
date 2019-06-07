package babysitter;

class InvalidStartTimeException extends RuntimeException {
    public InvalidStartTimeException(int startTime) {
        super(startTime + " is an invalid start time for a babysitter shift.");
    }

}
