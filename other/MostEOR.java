package pers.jack.other;

import java.util.HashMap;

public class MostEOR {
    public static int mostEOR(int[] arr) {
        int ans = 0;
        int xor = 0;
        int[] mosts = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                mosts[i] = pre == -1 ? 1 : (mosts[pre] + 1);
            }
            if (i > 0) {
                mosts[i] = Math.max(mosts[i - 1], mosts[i]);
            }
            map.put(xor, i);
            ans = Math.max(ans, mosts[i]);
        }
        return ans;
    }
}
