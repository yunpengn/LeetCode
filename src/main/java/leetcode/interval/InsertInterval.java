package leetcode.interval;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import leetcode.helpers.Interval;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        Iterator<Interval> iterator = intervals.listIterator();
        Interval current = iterator.next();
        while (current.start < newInterval.end) {
            result.add(current);
            current = iterator.next();
        }

        while (current.end < newInterval.end) {
            current = iterator.next();
        }
        Interval merged = new Interval(newInterval.start, Math.max(current.end, newInterval.end));
        result.add(merged);

        return result;
    }
}

