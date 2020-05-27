package curry.qin.Sort;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Sort
 * @date 2020/5/22 16:44
 * @Copyright © 2019-2020 yamibuy
 */
public class InsertSort {
    private static int[] insertSort(int[] arr){
        //从第二个数开始插入
        for(int index=1;index<arr.length;index++){
            //保存目前的数
            int temp=arr[index];
            //寻找要插入的位置,从当前数的前一个开始，直到数列开头
            int i;
            for (i=index-1;i>=0&&arr[i]>temp;i--){
                //每当目前遍历到的数比temp大，就让它往后挪一个，腾出位置
                arr[i+1]=arr[i];
            }
            arr[i+1]=temp;
    }
        return arr;
    }
}
