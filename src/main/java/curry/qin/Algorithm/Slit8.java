package curry.qin.Algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Algorithm
 * @date 2020/3/21 10:34
 * @Copyright © 2019-2020 yamibuy
 */
public class Slit8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firStr = sc.nextLine();
        String secStr = sc.nextLine();
        splitStr(firStr);
        splitStr(secStr);
    }
    private static void splitStr(String str){
        StringBuilder sb = new StringBuilder();
        if(str.length() <= 8){
            sb.append(str);
            for(int i =0;i< 8-str.length();i++){
                sb.append("0");
            }
            System.out.println(sb.toString());
            return;
        }
        sb.append(str);
        for(int i =0;i<sb.length()%8;i++){
            sb.append("0");
        }

        for(int i =0;i<sb.length()/8;i++){
            if(i ==0){
                System.out.println(sb.substring(0,8));
            }else{
                System.out.println(sb.substring(8*i,8*(i+1)));
            }
        }
    }
}
