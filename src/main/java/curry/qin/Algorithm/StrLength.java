package curry.qin.Algorithm;

import java.util.Scanner;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Algorithm
 * @date 2020/3/20 17:53
 * @Copyright © 2019-2020 yamibuy
 */
public class StrLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        String word = arr[arr.length-1];
        System.out.println(word.length());
    }
}
