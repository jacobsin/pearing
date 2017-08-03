package elevator;

public class Lift {


    private int floor = 1;

    public void up() {
        floor = floor + 1;
    }

    public int getFloor() {
        return floor;
    }
}
