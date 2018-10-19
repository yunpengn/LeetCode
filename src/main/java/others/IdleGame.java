package others;

public class IdleGame {
    private static class Result {
        int times;
        int extra;

        Result(int times, int extra) {
            this.times = times;
            this.extra = extra;
        }
    }

    // This version uses an efficient memoization table.
    static int calculateMinimum(int maxLevel, int amountRequired, int[] values, int[] costs) {
        Result[][] table = new Result[maxLevel + 1][costs[maxLevel] + 1];

        return calculateMinimum_(maxLevel, amountRequired, values, costs, table, costs[maxLevel]).times;
    }

    private static Result calculateMinimum_(int maxLevel, int amountRequired, int[] values, int[] costs, Result[][] table, int range) {
        if (amountRequired <= 0) {
            return new Result(0, 0);
        } else if (maxLevel == 0) {
            int times = numOfTaps(values[0], amountRequired);
            return new Result(times, values[0] * times - amountRequired);
        } else if (amountRequired <= range && table[maxLevel][amountRequired] != null) {
            return table[maxLevel][amountRequired];
        } else {
            // If we do not use the current level.
            Result skip = calculateMinimum_(maxLevel - 1, amountRequired, values, costs, table, range);

            // If we use the current level (need to tap as many times as possible since we have paid the cost).
            int min = Integer.MAX_VALUE;
            int extra = amountRequired;
            for (int prevLevel = 0; prevLevel < maxLevel; prevLevel++) {
                Result previous = calculateMinimum_(prevLevel, costs[maxLevel], values, costs, table, range);
                int numOfTaps = numOfTaps(values[maxLevel], amountRequired - previous.extra);
                if (previous.times + numOfTaps < min) {
                    min = previous.times + numOfTaps;
                    extra = numOfTaps * values[maxLevel] - (amountRequired - previous.extra);
                }
            }
            Result notSkip = new Result(min, extra);

            Result result;
            if (skip.times < notSkip.times || (skip.times == notSkip.times && skip.extra > notSkip.extra)) {
                result = skip;
            } else {
                result = notSkip;
            }
            if (amountRequired <= range) {
                table[maxLevel][amountRequired] = result;
            }
            return result;
        }
    }

    private static int numOfTaps(int value, int amountRequired) {
        return (int) Math.ceil(1.0 * amountRequired / value);
    }
}
