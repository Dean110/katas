package babysitter;

class InvalidEndTimeException extends RuntimeException {
    public InvalidEndTimeException(int endingTime) {
        super(endingTime + " is an invalid end time for a babysitter shift.");
    }
}
