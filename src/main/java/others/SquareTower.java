package others;

import java.util.Scanner;

public class SquareTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfWhite = sc.nextInt();
        int numOfBlack = sc.nextInt();

        int maxHeight = maxHeight(numOfWhite, numOfBlack, 1);
        int numOfWays = numOfWays(numOfWhite, numOfBlack, 1, maxHeight);
        System.out.printf("%d %d\n", maxHeight, 2);
    }

    private static int maxHeight(int numOfWhite, int numOfBlack, int currentHeight) {
        if (numOfWhite < 0 || numOfBlack < 0) {
            return currentHeight - 2;
        }
        return Math.max(
                maxHeight(numOfWhite - currentHeight, numOfBlack, currentHeight + 1),
                maxHeight(numOfWhite, numOfBlack - currentHeight, currentHeight + 1)
        );
    }

    private static int numOfWays(int numOfWhite, int numOfBlack, int currentHeight, int maxHeight) {
        if (numOfWhite < 0 || numOfBlack < 0) {
            return currentHeight - 2 == maxHeight ? 1 : 0;
        }

        return numOfWays(numOfWhite - currentHeight, numOfBlack, currentHeight + 1, maxHeight)
                + numOfWays(numOfWhite, numOfBlack - currentHeight, currentHeight + 1, maxHeight);
    }
}
