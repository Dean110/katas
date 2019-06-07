package babysitter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class BabySitterTest {

    private WageCalculator underTest;

    private void assertInvalidStartTimeExceptionThrown(int startingHour) {
        try {
            underTest.calculateShiftWage(startingHour, 18, 20);
            fail("Did not throw expected InvalidStartTimeException.");
        } catch (InvalidStartTimeException exception) {
            assertThat(exception.getMessage(), is(startingHour + " is an invalid start time for a babysitter shift."));
        }
    }

    private void assertInvalidEndTimeExceptionThrown(int endingHour) {
        try {
            underTest.calculateShiftWage(17, endingHour, 20);
            fail("Did not throw expected InvalidEndTimeException");
        } catch (InvalidEndTimeException exception) {
            assertThat(exception.getMessage(), is(endingHour + " is an invalid end time for a babysitter shift."));
        }
    }

    private void assertInvalidTimePunchExceptionThrown(int startingHour, int endingHour) {
        try {
            underTest.calculateShiftWage(startingHour, endingHour, 20);
            fail("Expected InvalidTimePunchesException not thrown");
        } catch (InvalidTimePunchesException exception) {
            assertThat(exception.getMessage(), is("Start time is the same time or after end time"));
        }
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
        int wage = underTest.calculateShiftWage(17, 18, 20);
        assertThat(wage, is(12));
    }

    @Test
    public void oneHourPostBedtimePreMidnightShouldPay8(){
        int wage = underTest.calculateShiftWage(21,22,20);
        assertThat(wage, is(8));
    }
    @Test
    public void oneHourPostMidnightShouldPay16(){
        int wage = underTest.calculateShiftWage(0,1,20);
        assertThat(wage, is(16));
    }

}
