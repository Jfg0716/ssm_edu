package com.jinfg.newcode;

import java.util.Scanner;

/**
 * @author jinfg
 * @date 2021/6/17 18:58
 */
public class jinString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串和反转的个数:");
        String s = sc.nextLine();
        int n = sc.nextInt();
        String s1 = reverseLeftWords(s, n);
        System.out.println("反转后的字符串：" + s1);

        String s2 = reverseLeftWords2(s, n);
        System.out.println("反转后的字符串：" + s2);

    }

    /*
    *   1.输入：一个字符串
        2.输出：一个字符串
        3.要求:（1）去除原字符串中的重复字符
                （2）要保证在原字符串中的相对顺序
                （3）输出字符串的字典序最小
    * */
    public static String reverseLeftWords(String str,int n){
        if (str == null && n == 0) return str;

        StringBuffer sb = new StringBuffer();
        char[] chars = str.toCharArray();
        int m = chars.length;
        for (int i = n; i < m;i++){
            sb.append(chars[i]);
        }
        for (int i = 0; i< n; i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    //方法二
    public static String reverseLeftWords2(String str,int n){
        StringBuffer sb = new StringBuffer();
        int len = str.length();

        //sb.append(str,start,end); 向sb中添加str中位置从start开始到end结束部分的字串
        sb.append(str,n,len);
        sb.append(str,0,n);
        return sb.toString();
    }

    //方法三
    public static String reverseLeftWords3(String str,int n){
        return str.substring(n,str.length()) + str.substring(0,n);
    }

}
