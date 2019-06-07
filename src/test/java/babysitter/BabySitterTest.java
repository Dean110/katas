package babysitter;

import babysitter.WageCalculator.InvalidEndTimeException;
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
    public void shouldThrowInvalidStartTimeExceptionForAShiftStartingAt2Pm() {
        assertInvalidStartTimeExceptionThrown(14);
    }

    @Test
    public void shouldThrowInvalidStartTimeExceptionForAShiftStartingAt4Pm() {
        assertInvalidStartTimeExceptionThrown(16);
    }

    @Test
    public void shouldThrowInvalidStartTimeExceptionForAShiftStartingAt4Am(){
        assertInvalidStartTimeExceptionThrown(4);
    }

    @Test
    public void shouldThrowInvalidEndTimeExceptionForAShiftEndingAfter4Am(){
        try {
            underTest.calculateShiftWage(17, 5, 20);
            fail("Did not throw expected InvalidEndTimeException");
        }catch (InvalidEndTimeException exception){
            assertThat(exception.getMessage(), is("5 is an invalid end time for a babysitter shift."));
        }
    }

}
