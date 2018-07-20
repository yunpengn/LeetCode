package leetcode;

public abstract class Rand10 {
    public int rand10() {
        int firstTry;
        int secondTry;
        int result;

        do {
            firstTry = rand7();
            secondTry = rand7();
            result = (firstTry - 1) * 7 + secondTry;
        } while (result > 40);

        return (result - 1) % 10 + 1;
    }

    abstract int rand7();
}
