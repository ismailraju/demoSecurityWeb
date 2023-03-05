package com.example.demoSecurityWeb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {


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

        boolean flag = true;

        String result = "";

        int[][][] dp = new int[l1 + 1][l2 + 1][3];
        for (int i = 2; i <= l1; i++) {
            dp[i][0][1] = 1;
            dp[i][0][2] = 1;
        }
        for (int i = 2; i <= l2; i++) {
            dp[0][i][1] = 1;
            dp[0][i][2] = 1;
        }


        for (int i = 1; i <= l1; i++) {

            for (int j = 1; j <= l2; j++) {

                int max = Math.max(dp[i - 1][j - 1][0], Math.max(dp[i - 1][j][0], dp[i][j - 1][0]));
                if (aa[i] == bb[j]) {
                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1;
                    dp[i][j][1] = 0;

                    dp[i][j][2] = dp[i - 1][j - 1][2];
                } else {
                    dp[i][j][0] = max;
                    dp[i][j][1] = 1;


                    if (dp[i - 1][j - 1][0] == max) {
                        dp[i][j][2] = Math.max(dp[i][j][2], dp[i - 1][j - 1][2] + ((dp[i - 1][j - 1][1] == 0) ? 1 : 0));
                    }
                    if (dp[i - 1][j][0] == max) {
                        dp[i][j][2] = Math.max(dp[i][j][2], dp[i - 1][j][2] + ((dp[i - 1][j][1] == 0) ? 1 : 0));
                    }
                    if (dp[i][j - 1][0] == max) {
                        dp[i][j][2] = Math.max(dp[i][j][2], dp[i][j - 1][2] + ((dp[i][j - 1][1] == 0) ? 1 : 0));
                    }
                }

            }

        }

//        System.out.println(Arrays.deepToString(dp));


        int cnt = 0;

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

                int u = Integer.MAX_VALUE, p = 0;
                if (dp[i][j][0] == dp[i - 1][j][0]) {

                    if (dp[i - 1][j][2] < u) {
                        u = dp[i][j][2];
                        p = 1;
                    }

                }
                if (dp[i][j][0] == dp[i][j - 1][0]) {

                    if (dp[i][j - 1][2] < u) {
                        u = dp[i][j][2];
                        p = 2;
                    }

                }
                if (dp[i][j][0] == dp[i - 1][j - 1][0]) {

                    if (dp[i - 1][j - 1][2] < u) {
                        u = dp[i][j][2];
                        p = 3;
                    }
                }

                if (p == 1) {
                    i--;
                } else if (p == 2) {
                    j--;
                } else {
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
//        System.out.println(result);

        int l = result.length();
        if (l < (cnt * 2)) {
            return null;
        }


        return result;

    }

}