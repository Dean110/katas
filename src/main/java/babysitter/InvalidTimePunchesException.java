package babysitter;

class InvalidTimePunchesException extends RuntimeException {
    public InvalidTimePunchesException() {
        super("Start time is the same time or after end time");
    }
}
