package elevator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LiftTest {

    Lift lift;

    @Before
    public void setUp() throws Exception {
        lift = new Lift();
    }

    @Test
    public void goUpAndGetFloorReturnFloor2() throws Exception {

        lift.up();
        assertThat(lift.getFloor(), equalTo(2));
    }

    @Test
    public void goUpUpAndGetFloorReturnFloor3() {
        lift.up();
        lift.up();
        assertThat(lift.getFloor(), equalTo(3));
    }


}
