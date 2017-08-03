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

    @Test(expected = UnsupportedOperationException.class)
    public void cannotGoDownFromFloor1() throws Exception {
        lift.down();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cannotGoUpFromFloor5() throws Exception {
        lift.up().up().up().up();
        assertThat(lift.getFloor(), equalTo(5));
        lift.up();
    }

    @Test
    public void goUpUpUpUpAndGetFloor() throws Exception {
        lift.up().up().up();
        assertThat(lift.getFloor(), equalTo(4));

        lift.up();
        assertThat(lift.getFloor(), equalTo(5));
    }

    @Test
    public void iCanGetTheStepsWhenGotofloor3() throws Exception {
        Steps ret = lift.go(3).dryrun();

        assertThat(ret.toList(), equalTo(["UP", "UP", "OPEN", "CLOSE"]))
    }


    @Test
    public void iCanGetTheStepsWhenGotofloor4() throws Exception {
        Steps ret = lift.go(4).dryrun();

        assertThat(ret.toList(), equalTo(["UP", "UP", "UP", "OPEN", "CLOSE"]))
    }

    @Test
    public void iCanGetTheStepsWhenGotoFloor4and2() throws Exception {
        Steps ret = lift.go(4).go(2).dryrun()

        assertThat(ret.toList(), equalTo(["UP", "OPEN", "CLOSE", "UP", "UP", "OPEN", "CLOSE"]))

    }
}

