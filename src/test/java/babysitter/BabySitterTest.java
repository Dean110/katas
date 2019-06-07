package babysitter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;

public class BabySitterTest {

    private WageCalculator underTest;

    private void assertInvalidStartTimeExceptionThrown(int startingHour) {
        try {
            underTest.calculateShiftWage(startingHour, 18, 20);
            fail("Did not throw expected InvalidStartTimeException.");
        } catch (InvalidStartTimeException exception) {
            assertThat(exception.getMessage(), equalTo(startingHour + " is an invalid start time for a babysitter shift."));
        }
    }

    private void assertInvalidEndTimeExceptionThrown(int endingHour) {
        try {
            underTest.calculateShiftWage(17, endingHour, 20);
            fail("Did not throw expected InvalidEndTimeException");
        } catch (InvalidEndTimeException exception) {
            assertThat(exception.getMessage(), equalTo(endingHour + " is an invalid end time for a babysitter shift."));
        }
    }

    private void assertInvalidTimePunchExceptionThrown(int startingHour, int endingHour) {
        try {
            underTest.calculateShiftWage(startingHour, endingHour, 20);
            fail("Expected InvalidTimePunchesException not thrown");
        } catch (InvalidTimePunchesException exception) {
            assertThat(exception.getMessage(), equalTo("Start time is the same time or after end time"));
        }
    }

    private void assertShiftWages(int startingHour, int endingHour, int bedtime, int expectedWage) {
        int wage = underTest.calculateShiftWage(startingHour, endingHour, bedtime);
        assertThat(wage, equalTo(expectedWage));
    }

    @Before
    public void setUp() {
        underTest = new WageCalculator();
    }

    @Test
    public void invalidStartandEndTimesThrowExceptions() {
        assertInvalidStartTimeExceptionThrown(14);
        assertInvalidStartTimeExceptionThrown(16);
        assertInvalidStartTimeExceptionThrown(4);
        assertInvalidEndTimeExceptionThrown(5);
        assertInvalidEndTimeExceptionThrown(6);
        assertInvalidEndTimeExceptionThrown(17);
    }

    @Test
    public void invalidTimePunchExceptionScenarios() {
        assertInvalidTimePunchExceptionThrown(19, 18);
        assertInvalidTimePunchExceptionThrown(18, 18);
        assertInvalidTimePunchExceptionThrown(2, 18);
    }

    @Test
    public void oneHourPreBedtimePreMidnightShouldPay12() {
        assertShiftWages(17, 18, 20, 12);
    }

    @Test
    public void oneHourPostBedtimePreMidnightShouldPay8() {
        assertShiftWages(21, 22, 20, 8);
    }

    @Test
    public void oneHourPostMidnightShouldPay16() {
        assertShiftWages(0, 1, 20, 16);
    }

    @Test
    public void twoHoursPreBedtimePreMidnightShouldPay24() {
        assertShiftWages(17, 19, 20, 24);
    }

    @Test
    public void twoHoursPostBedtimePreMidnightShouldPay16() {
        assertShiftWages(20, 22, 20, 16);
    }

    @Test
    public void twoHoursPostMidnightShouldPay32() {
        assertShiftWages(0, 2, 22, 32);
    }
    @Ignore
    @Test
    public void oneHourBeforeBedtimeOneHourAfterBedtimeBeforeMidnightShouldPay20(){
        assertShiftWages(20,22,21,20);
    }
}
