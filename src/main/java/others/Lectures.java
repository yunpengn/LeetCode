package others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

class Lectures {
    int calculateMinimumHalls(int N, int[] start, int[] end) {
        // Creates a priority queue containing the moments needed to consider.
        PriorityQueue<Moment> moments = insertAllMoments(start, end);

        // Creates a queue containing all the available halls (can manually
        // create a new hall).
        Queue<Integer> availableHalls = new LinkedList<>();

        // Counts the number of halls created so far.
        int hallCount = 0;
        // Assignment from lecture ID to hall ID.
        int[] assignment = new int[N];

        // Arranges each lecture into the first available hall.
        while (!moments.isEmpty()) {
            Moment current = moments.poll();

            if (current.type == MomentType.START) {
                if (availableHalls.isEmpty()) {
                    int newHall = hallCount;
                    assignment[current.lectureId] = newHall;
                    hallCount++;
                } else {
                    int oldHall = availableHalls.poll();
                    assignment[current.lectureId] = oldHall;
                }
            } else {
                // Since start[i] < end[i], this lecture must have been assigned a hall at this moment.
                int assignedHall = assignment[current.lectureId];
                availableHalls.add(assignedHall);
            }
        }

        return hallCount;
    }

    int calculateMinimumCancels(int N, int L, int[] start, int[] end) {
        // Creates a sorted array of all lectures.
        Session[] lectures = insertAndSortAllLectures(start, end);

        // Uses this status board to store information about all halls.
        HallStatusBoard status = new HallStatusBoard(L);

        // Counts the number of lectures cancelled.
        int cancelCount = 0;

        for (int i = 0; i < N; i++) {
            Session current = lectures[i];

            // If cannot find any best hall, that means this lecture must be cancelled.
            if (!status.getBestHallAndUpdateStartTime(current.start, current.end)) {
                cancelCount++;
            }
        }

        return cancelCount;
    }

    private PriorityQueue<Moment> insertAllMoments(int[] start, int[] end) {
        // Creates a priority queue containing the moments needed to consider.
        PriorityQueue<Moment> moments = new PriorityQueue<>();

        // Inserts the starting & ending points of all lectures.
        for (int i = 0; i < start.length; i++) {
            Moment startMoment = new Moment(start[i], MomentType.START, i);
            moments.add(startMoment);
            Moment endMoment = new Moment(end[i], MomentType.END, i);
            moments.add(endMoment);
        }

        return moments;
    }

    private Session[] insertAndSortAllLectures(int[] start, int[] end){
        Session[] result = new Session[start.length];
        
        // Inserts each lecture.
        for (int i = 0; i < start.length; i++) {
            result[i] = new Session(start[i], end[i]);
        }

        // Returns the sorted array according to end time.
        Arrays.sort(result);
        return result;
    }
}

/**
 * A {@link HallStatusBoard} is a point-of-access for information regarding all halls
 * at the current moment. Minimally, it stores the ending time of lectures going on
 * currently in all lecture halls.
 */
class HallStatusBoard {
    class Hall implements Comparable<Hall> {
        int id;
        int endTime;

        Hall(int id, int endTime) {
            this.id = id;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Hall other) {
            int diff = this.endTime - other.endTime;
            if (diff == 0) {
                return this.id - other.id;
            } else {
                return diff;
            }
        }
    }

    // A tree map whose keys are the IDs of all halls, whose values are the ending times
    // of lectures going on in respective halls. TreeSet is used here to maintain the
    // order of all halls by ending time.
    private final TreeSet<Hall> status = new TreeSet<>();

    HallStatusBoard(int numOfHalls) {
        // Initializes the ending times of all halls to be -1 (dummy value).
        for (int i = 0; i < numOfHalls; i++) {
            status.add(new Hall(i, -1));
        }
    }

    /**
     * Finds the best hall and updates the status of that hall. A hall is defined to be the
     * best if the end-time of the previous lecture in that hall is nearest to the start-time
     * of this lecture. Therefore, this query is equivalent to a standard predecessor operation.
     *
     * @param startTime is the start time of the lecture in concern.
     * @param endTime is the new end time for that best hall selected.
     *
     * @return true unless we cannot find any hall available.
     */
    boolean getBestHallAndUpdateStartTime(int startTime, int endTime) {
        // Inserts a dummy entry to the TreeSet.
        Hall dummyHall = new Hall(Integer.MAX_VALUE, startTime);
        status.add(dummyHall);

        // Gets the best hall and removes.
        Hall predecessor = status.lower(dummyHall);
        if (predecessor == null) {
            return false;
        }
        status.remove(dummyHall);
        status.remove(predecessor);

        // Updates the status of the best hall selected.
        predecessor.endTime = endTime;
        status.add(predecessor);
        return true;
    }
}

/**
 * Uses the {@link Session} class to represent lecture sessions.
 */
class Session implements Comparable<Session> {
    final int start;
    final int end;

    Session(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Session other) {
        return this.end - other.end;
    }
}

/**
 * Each lecture consists of two {@link Moment}s, one of type {@code START},
 * the other of type {@code END}.
 */
class Moment implements Comparable<Moment> {
    private final int value;
    final MomentType type;
    final int lectureId;

    Moment(final int value, final MomentType type, final int lectureId) {
        this.value = value;
        this.type = type;
        this.lectureId = lectureId;
    }

    @Override
    public int compareTo(Moment other) {
        int diff = this.value - other.value;
        if (diff != 0) {
            return diff;
        } else {
            // When the time is the same, moment of END type has higher priority (
            // because for back-to-back arrangement, we need to finish the previous
            // lecture first then start the next one).
            if (this.type == MomentType.END) {
                return -1;
            } else if (other.type == MomentType.END) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

/**
 * Defines the two different types of the {@link Moment} class.
 */
enum MomentType {
    START, END
}
