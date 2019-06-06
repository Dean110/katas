package babysitter;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class BabySitterTest {

    @Test
    public void oneHourPreBedTimeShouldPay12() {
        WageCalculator underTest = new WageCalculator();
        int wage = underTest.calculateShiftWage(17, 18, 20);
        assertThat(wage, is(12));
    }

    @Test
    public void shouldThrowInvalidStartTimeException() {
        WageCalculator underTest = new WageCalculator();
        try {
            int wage = underTest.calculateShiftWage(14, 18, 20);
            fail("Did not throw expected exception.");
        } catch (babysitter.WageCalculator.InvalidStartTimeException exception) {
            assertThat(exception.getMessage(), is("14 is an invalid start time for a babysitter shift."));
        }
    }

}
