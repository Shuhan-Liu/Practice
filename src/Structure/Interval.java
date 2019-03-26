package Structure;

/**
 * Created by shuhanliu on 3/23/19.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString(){
        return start + "-" + end;
    }
}
