package com.barran.algorithm.matchstr;

import java.util.HashMap;

/**
 * kmp,由Daniel M.Sunday在1990年提出
 *
 * <p>
 * 从前往后匹配，在匹配失败时关注的是文本串中参加匹配的最末位字符的下一位字符:<br/>
 * 如果该字符没有在模式串中出现则直接跳过，即移动位数 = 匹配串长度 + 1；<br/>
 * 否则，其移动位数 = 模式串中最右端的该字符到末尾的距离+1。
 * </p>
 */
public class SundayMatcher implements IStringMatcher {
    @Override
    public int match(String content, String pattern) {
        int i = 0;
        int j = 0;

        char[] t = content.toCharArray();
        char[] p = pattern.toCharArray();

        HashMap<Integer, Integer> charIndex = new HashMap<>();
        for (int x = 0; x < p.length; x++) {
            charIndex.put((int) p[x], x);
        }

//        System.out.println(charIndex.toString());

        final int tLength = content.length();
        final int pLength = pattern.length();
        while (i <= (tLength - pLength + j)) {
//            System.out.println("i&j " + i + "," + j);
//            System.out.println("t&p " + t[i] + "," + p[j]);

            boolean equal = t[i] == p[j];
//            System.out.println("equal " + equal);

            if (equal) {

                if (j == pLength - 1) {
                    return i - j;
                }

                i++;
                j++;
            } else {
                char nextChar = t[i + pLength - j];
                int next = charIndex.getOrDefault((int) nextChar, -1);
//                System.out.println("next " + next + ", char " + nextChar);
                i = i + pLength - next - j;
//                System.out.println("i " + i);
                j = 0;
            }

        }

        return -1;
    }
}
