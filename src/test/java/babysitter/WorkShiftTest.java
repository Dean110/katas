package babysitter;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class WorkShiftTest {

    @Test
    public void shiftThatStartsAfterMidnightAndLastsOneHourShouldHaveOneHourPostMidnightHours(){
        WorkShift underTest = new WorkShift(1,3,22);
        MatcherAssert.assertThat(underTest.getPostMidnightHours(), IsEqual.equalTo(2));
    }
}