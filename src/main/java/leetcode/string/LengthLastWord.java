package leetcode.string;

public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();

        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
