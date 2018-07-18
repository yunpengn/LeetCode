package leetcode.helpers;

import java.util.Objects;

public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0; end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Interval)) {
            return false;
        } else {
            Interval other = (Interval) obj;
            return this.start == other.start && this.end == other.end;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
