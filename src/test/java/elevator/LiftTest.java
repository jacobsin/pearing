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
    public void goUpAndGetFloor() throws Exception {
        lift.up();
        assertThat(lift.getFloor(), equalTo(2));
    }

    @Test
    public void goUpUpAndGetFloor() {
        lift.up();
        lift.up();
        assertThat(lift.getFloor(), equalTo(3));
    }

    @Test
    public void goDownAndGetFloor() throws Exception {
        lift.up().up();
        lift.down();

        assertThat(lift.getFloor(), equalTo(2));
    }

    @Test
    public void goDownDownAndGetFloor() throws Exception {
        lift.up().up();
        lift.down().down();

        assertThat(lift.getFloor(), equalTo(1));
    }
}

