package com.example.demoSecurityWeb;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution1 {


    public static void main(String args[]) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("C:\\Users\\Raju\\Downloads\\demoSecurityWeb\\src\\test\\java\\com\\example\\demoSecurityWeb\\input.txt"));
        int t = sc.nextInt();
        while (t-- > 0) {


            String a = sc.next();
            String b = sc.next();


            String templete = getTemplete(a, b);
            if (templete == null) {
                System.out.println("NO");

            } else {

                System.out.println("YES");
                System.out.println(templete);
            }
        }


    }

    public static String getTemplete(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();
        char[] aa = (" " + a).toCharArray();
        char[] bb = (" " + b).toCharArray();


        String result = "";

        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {

            for (int j = 1; j <= l2; j++) {

                int max = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
                if (aa[i] == bb[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max;
                }

            }

        }


//        result = getString(l1, l2, aa, bb, result, dp);

        Object[] s = getString2(dp, aa, bb, l1, l2, " ", 0);

        result = ((String) s[0]).trim();
        int cnt = (Integer) s[1];
//        System.out.println(Arrays.deepToString(s));
        int l = result.length();
        if (l < (cnt * 2)) {
            return null;
        }

        return result;

    }

    private static Object[] getString2(int[][] dp, char[] aa, char[] bb, int i, int j, String result, Integer astrCnt) {
        int l2 = dp[0].length, l1 = dp.length;
        boolean flag = (result.charAt(0) == '*');
        if (i == 0 && j == 0) return new Object[]{result, astrCnt};
        if (i == 0 || j == 0) return new Object[]{(flag ? result : "*" + result), astrCnt + 1};
        String r = "";
        Integer cnt = 0;
        List<Object[]> list = new ArrayList<Object[]>();


        if (((dp[i][j] == dp[i - 1][j - 1] + 1) && (aa[i] == bb[j]))) {
            Object[] r1 = getString2(dp, aa, bb, i - 1, j - 1, aa[i] + result, astrCnt);
            list.add(r1);
        } else if ((dp[i][j] == dp[i - 1][j - 1])) {
            Object[] r1 = getString2(dp, aa, bb, i - 1, j - 1, (flag ? result : "*" + result), (flag ? astrCnt : astrCnt + 1));
            list.add(r1);
        }

        if ((dp[i][j] == dp[i - 1][j])) {
            Object[] r2 = getString2(dp, aa, bb, i - 1, j, (flag ? result : "*" + result), (flag ? astrCnt : astrCnt + 1));
            list.add(r2);
        }
        if ((dp[i][j] == dp[i][j - 1])) {
            Object[] r3 = getString2(dp, aa, bb, i, j - 1, (flag ? result : "*" + result), (flag ? astrCnt : astrCnt + 1));
            list.add(r3);
        }

        Optional<Object[]> min = list.stream().min((a, b) -> ((Integer) a[1] - (Integer) b[1]));

        return min.get();
    }

    private static String getString(int l1, int l2, char[] aa, char[] bb, String result, int[][] dp) {
        int cnt = 0;
        boolean flag = true;
        int i = 0, j = 0;
        for (i = l1, j = l2; i > 0 && j > 0; ) {

            if (aa[i] == bb[j]) {

                result = aa[i] + result;
                i--;
                j--;
                flag = true;
            } else {

                if (flag) {
                    result = "*" + result;
                    flag = false;
                    cnt++;
                }

                if (dp[i][j] == dp[i - 1][j]) {
                    i--;

                } else if (dp[i][j] == dp[i][j - 1]) {
                    j--;

                } else if (dp[i][j] == dp[i - 1][j - 1]) {
                    i--;
                    j--;
                }

            }

        }

        if (flag && (i > 0 || j > 0)) {
            result = "*" + result;
            flag = false;
            cnt++;
        }


        int l = result.length();
        if (l < (cnt * 2)) {
            return null;
        }
        return result;
    }

}