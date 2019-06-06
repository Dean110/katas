package babysitter;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BabySitterTest {
    @Test
    public void oneHourPreBedTimeShouldPay12() {
        WageCalculator underTest = new WageCalculator();
        int wage = underTest.calculateShiftWage(17, 18, 20);
        assertThat(wage, is(12));
    }
}
