package curry.qin.Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Algorithm
 * @date 2020/3/21 15:36
 * @Copyright © 2019-2020 yamibuy
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firStr = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        String[] words = firStr.split(" ");
        for(int i = words.length-1;i >=0;i--){
            sb.append(words[i]);
            if(i > 0 ){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
