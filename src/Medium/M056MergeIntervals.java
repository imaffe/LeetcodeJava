package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class M056MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        // how to do more advanced sort over tuples
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> merged = new ArrayList<>();
        for (Interval interval : intervals) {
            if(merged.isEmpty()) {

            } else {

            }
        }
        return null;
    }
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
}
