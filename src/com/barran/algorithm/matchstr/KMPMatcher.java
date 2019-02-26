package com.barran.algorithm.matchstr;

/**
 * kmp
 *
 * <p>
 * 核心是理解next[]数组的算法：
 * </p>
 */
public class KMPMatcher implements IStringMatcher {
    @Override
    public int match(String content, String pattern) {
        char[] t = content.toCharArray();
        char[] p = pattern.toCharArray();

        int i = 0;
        int j = 0;

        int[] next = getNext(pattern);

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getNext(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];
        char[] chars = pattern.toCharArray();

        next[0] = -1;
        int k = -1;
        int j = 0;

        while (j < length - 1) {
            if (k == -1 || chars[k] == chars[j]) {
                k++;
                j++;
                // 相等时跳过
                if (chars[j] == chars[k]) {
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }

        return next;
    }
}
