package curry.qin.Algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Algorithm
 * @date 2020/3/20 17:57
 * @Copyright © 2019-2020 yamibuy
 */
public class CharCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String chaStr = sc.nextLine();
        String word = sc.next();
        Map<String,Integer> countMap = new HashMap<>();
        for(Character str : chaStr.toCharArray()){
            if(countMap.containsKey(str.toString().toLowerCase())){
                countMap.put(str.toString().toLowerCase(), countMap.get(str.toString().toLowerCase())+1);
                continue;
            }
            countMap.put(str.toString().toLowerCase(), 1);
        }
        System.out.println(countMap.get(word)==null ? 0 : countMap.get(word));
    }
}
