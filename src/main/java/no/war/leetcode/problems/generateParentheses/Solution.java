package no.war.leetcode.problems.generateParentheses;

import java.util.*;

public class Solution {

    public static List<String> generateParenthesis(int n) {
        var result = new HashSet<String>();
        var arr = new int[n << 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((i & 1) == 0) ? 0 : 1;
        }

        result.add(convert(arr));
        calc(arr, result);

        return new ArrayList<>(result);
    }

    private static String convert(int[] a) {
        var sb = new StringBuilder();

        for (int j : a) {
            sb.append(j == 1 ? ")" : "(");
        }

        return sb.toString();
    }

    private static void calc(int[] a, Set<String> result) {
        int[] copy = Arrays.copyOfRange(a, 0, a.length);
        for (int i = 1; i < copy.length - 1; i++) {
            if (i + 1 == copy.length - 1) {
                break;
            }
            if (copy[i] == 1 && copy[i + 1] == 0) {
                copy[i] = 0;
                copy[i + 1] = 1;
                String convert = convert(copy);
                if (!result.contains(convert)) {
                    result.add(convert);
                    calc(copy, result);
                }
                copy[i] = 1;
                copy[i + 1] = 0;
            }
        }
    }
}
