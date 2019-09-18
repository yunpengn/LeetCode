package others;

public class ReverseWithSpecialChar {
    String reverse(String str) {
        char[] arr = str.toCharArray();
        int first = 0;
        int second = arr.length - 1;

        while (first < second && first < arr.length && second >= 0) {
            if (!Character.isAlphabetic(arr[first])) {
                first++;
            } else if (!Character.isAlphabetic(arr[second])) {
                second--;
            } else {
                swap(arr, first, second);
                first++;
                second--;
            }
        }

        return new String(arr);
    }

    private void swap(char[] arr, int first, int second) {
        char temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
