package elevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lift {

    private static final int TOP_FLOOR = 5;
    private int floor = 1;
    private List<Integer> reqs = new ArrayList<>();

    public Lift up() {
        if (floor >= TOP_FLOOR) {
            throw new UnsupportedOperationException();
        }
        floor++;
        return this;
    }

    public Lift down() {
        if (floor == 1) throw new UnsupportedOperationException();
        floor--;
        return this;
    }

    public int getFloor() {
        return floor;
    }

    public Steps dryrun() {
        Steps steps = new Steps();

        for (int i = this.getFloor(); i < reqs.get(0); i++) {
            if(reqs.contains(i))
            {
                steps.add("OPEN");
                steps.add("CLOSE");
            }
            steps.add("UP");
        }

        steps.add("OPEN");
        steps.add("CLOSE");

        return steps;
    }

    public Lift  go(int targetFloor) {
        reqs.add(targetFloor);
        return this;

    }
}
