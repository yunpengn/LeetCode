package others;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lectures {
    int calculateMinimumHalls(int N, int[] start, int[] end) {
        // Creates a priority queue containing the moments needed to consider.
        PriorityQueue<Moment> moments = new PriorityQueue<>();

        // Creates a queue containing all the available halls (can manually
        // create a new hall).
        Queue<Integer> availableHalls = new LinkedList<>();

        // Counts the number of halls created so far.
        int hallCount = 0;

        // Assignment from lecture ID to hall ID.
        int[] assignment = new int[N];

        // Inserts the starting & ending points of all lectures.
        for (int i = 0; i < N; i++) {
            Moment startMoment = new Moment(start[i], MomentType.START, i);
            moments.add(startMoment);
            Moment endMoment = new Moment(end[i], MomentType.END, i);
            moments.add(endMoment);
        }

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
        return 0;
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
