package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIP("", s, 0, result);
        return result;
    }

    private void restoreIP(String addr, String remain, int currentLevel, List<String> result) {
        if (remain.isEmpty() && currentLevel == 4) {
            result.add(addr.substring(1));
        } else if (remain.isEmpty() || currentLevel == 4) {
            return;
        } else {
            for (int i = 1; i <= remain.length() && i <= (remain.charAt(0) == 48 ? 1 : 3); i++) {
                String part = remain.substring(0, i);
                if (Integer.parseInt(part) < 256) {
                    restoreIP(addr + "." + part, remain.substring(i), currentLevel + 1, result);
                }
            }
        }
    }
}
