package curry.qin;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin
 * @date 2020/3/28 9:19
 * @Copyright © 2019-2020 yamibuy
 */
public class BinearrySearch {
    public static void main(String[] args) {
//      int[] nums = new int[]{99,55,3,15,2,12,35,6,2,14,13};
//        bucketSort(nums);
        ZonedDateTime date1 =ZonedDateTime.now(ZoneId.ofOffset("GMT", ZoneOffset.of("-2")));

//        String start_am_pm = getMethodName(Month.of(LocalDateTime.now().getMonthValue()).toString().toLowerCase());
//        int start = LocalDateTime.now().get(ChronoField.MINUTE_OF_HOUR);
//        System.out.println(start_am_pm+":"+start);

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(),LocalTime.of(12,0 ,0 ));
        System.out.println(localDateTime.get(ChronoField.AMPM_OF_DAY));

        System.out.println( Math.log(4));
    }

    private static String getMethodName(String fildeName) {
        byte[] byarray = fildeName.getBytes();
        byarray[0] = (byte) ((char) byarray[0] - 'a' + 'A');
        return new String(byarray);
    }

    /***
     * 二分查找  排好序的从小到大的顺序的一个列表 可以用此方法去查找
     * @param datas
     * @param findValue
     * @return
     */
    private Integer binearySearch(List<Integer> datas,Integer findValue){
        Integer start = 0;
        Integer end = datas.size();
        while (start <= end){
            Integer mid = (start+end)/2;
            if(datas.get(mid) == findValue){
                return mid;
            }
            //如果查找的比中间的大，起点开始为中间位置在加一
            else if(datas.get(mid) < findValue){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
    private  static void maopao (int[] nums){
        for(int i = nums.length-1;i>=1;i-- ){
            adjoinCompare(nums,i);
        }
    }

    /***
     * 相邻的互相比较将大的置换到后边
     * @param nums
     */
    private static void adjoinCompare(int[] nums,int n){
        for(int i = 0; i <n;i++){
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
    }

    /***
     * 查找一组数的最大的值的索引位置
     * @param nums
     */
    private static int  findMaxPos(int[] nums,int n){
        int maxPos = 0;
        int maxPosData = Integer.MIN_VALUE;
        for(int i = 0; i <n;i++){
            if(nums[i] > maxPosData ){
                maxPosData = nums[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    private static void   selectionCompare(int[] nums){
        int n = nums.length;
        while (n >= 1){
            int pos = findMaxPos(nums,n);
            int temp = nums[pos];
            nums[pos] = nums[n-1];
            nums[n-1] = temp;
            n --;
        }
    }

    private static void   bucketSort(int[] nums){
        int n = nums.length;
        Map<Integer,List<Integer>> sortMap = new TreeMap<>();
        for(int i = 0;i< nums.length;i++){
            int index = nums[i]*n/1000;
            if(sortMap.containsKey(index)){
                List<Integer> temp =  sortMap.get(index);
                temp.add( nums[i]);
                sortMap.put(index, temp );
                continue;
            }
            List<Integer> temp =  new ArrayList<>();
            temp.add( nums[i]);
            sortMap.put(index, temp );
        }
        List<Integer> ss = new ArrayList<>();
        sortMap.entrySet().stream().forEach(info ->{
            Arrays.sort(info.getValue().toArray());
            ss.addAll(info.getValue());
        });
        ss.forEach(s->System.out.println(s));
    }

    /***
     * 两个数相同的话异或返回0
     * @param nums
     * @return
     */
    private static int yihuo(int[] nums){
        int res = 0;
        for(int i = 0;i< nums.length;i++){
            res = (res ^ nums[i]);
        }
        return res;
    }

    /***
     * 两个字符串是否由相同元素构成 ex：cattts  == ctsasccats true
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAnagram(String s1,String s2){
        boolean res = false;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for(char s : s1.toCharArray()){
            int index = s -'a';
            s1Arr[index] = 1;
        }
        for(char s : s2.toCharArray()){
            int index = s -'a';
            s2Arr[index] = 1;
        }

        for(int i =0;i< 26; i++){
            if(s1Arr[i] != s2Arr[i]){
                res = false;
                break;
            }
        }
        return res;
    }

    private static void moveDataToLast(int[] nums,int n){
        int nCount = 0;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] == n){
                nCount++;
                continue;
            }
            nums[i - nCount] = nums[i];
        }
    }

    /***
     * 判断数组是否有重复数字，利用set去重之后看长度是否和数组长度一致
     * @param nums
     * @return
     */
     public static boolean containsDuplicate(int[] nums) {
         return new HashSet<>(Arrays.asList(nums)).size() != Arrays.asList(nums).size();
     }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i< nums.length-k;i++){
            for(int j = 1;j<k;j++){
                int res = nums[i] ^ nums[i+j];
                if(res == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
