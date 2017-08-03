package elevator;

import java.util.ArrayList;
import java.util.List;

public class Steps {
    private List<String> steps = new ArrayList<>();

    public int getLength() {
        return steps.size();
    }

    public String get(int idx) {
        return steps.get(idx);
    }

    public void add(String step) {
        steps.add(step);
    }

    public List<String> toList(){
        return steps;
    }
}
