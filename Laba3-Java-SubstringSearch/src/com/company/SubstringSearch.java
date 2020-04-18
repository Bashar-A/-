package com.company;

import java.util.HashMap;

public class SubstringSearch {
    public static int Boyer(String string, String substring) {
        int substringLen = substring.length();
        int stringLen = string.length();
        if (substringLen > stringLen) {
            return -1;
        }
        HashMap<Character, Integer> t = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            t.put((char) i, substringLen);
        }
        for (int i = 0; i < substringLen - 1; i++) {
            t.put(substring.charAt(i), substringLen - i - 1);
        }
        int i = substringLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= stringLen - 1) {
            j = substringLen - 1;
            k = i;
            while (j >= 0 && string.charAt(k) == substring.charAt(j)) {
                k--;
                j--;
            }
            i += t.get(string.charAt(i));
        }
        if (k >= stringLen - substringLen) {
            return -1;
        } else {
            return k + 1;
        }
    }
}
