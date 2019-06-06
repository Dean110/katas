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
            fail("Did not throw expected exception.");
        } catch (WageCalculator.InvalidStartTimeException exception) {
            assertThat(exception.getMessage(), is(startingHour + " is an invalid start time for a babysitter shift."));
        }
    }

    @Before
    public void setUp() {
        underTest = new WageCalculator();
    }

    @Test
    public void oneHourPreBedTimeShouldPay12() {
        int wage = underTest.calculateShiftWage(17, 18, 20);
        assertThat(wage, is(12));
    }

    @Test
    public void shouldThrowInvalidStartTimeExceptionForAShiftStartingAt2() {
        assertInvalidStartTimeExceptionThrown(14);
    }

    @Test
    public void shouldThrowInvalidStartTimeExceptionForAShiftStartingAt4() {
        assertInvalidStartTimeExceptionThrown(16);
    }

}
