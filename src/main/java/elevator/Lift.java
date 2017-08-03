package elevator;

public class Lift {

    private int floor = 1;

    public Lift up() {
        floor++;
        return this;
    }

    public Lift down() {
        floor--;
        return this;
    }

    public int getFloor() {
        return floor;
    }
}
