package curry.qin.Algorithm;

import com.google.common.collect.Lists;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Algorithm
 * @date 2020/3/21 14:39
 * @Copyright © 2019-2020 yamibuy
 */
public class BigdecimalTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X = sc.nextLine();
        List<String> paramList = new ArrayList();
        for (int i = 0; i < Integer.valueOf(X) ; i++) {
            String cparam=sc.nextLine();
            paramList.add(cparam);
        }
        Map<Integer, Integer> treemap = new TreeMap<>();
        for(String str : paramList){
            Integer key = Integer.valueOf(str.split(" ")[0]);
            Integer value = Integer.valueOf(str.split(" ")[1]);
            if(treemap.containsKey(key)){
                treemap.put(key, treemap.get(key)+value);
                continue;
            }
            treemap.put(key, value);
        }
        for(Map.Entry entry: treemap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
