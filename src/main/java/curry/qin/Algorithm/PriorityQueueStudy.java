package curry.qin.Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin.Algorithm
 * @date 2020/5/22 10:53
 * @Copyright © 2019-2020 yamibuy
 */
public class PriorityQueueStudy {
    public static void main(String[] args) {
        // 构建大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(5, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });
        maxHeap.add(10);
        maxHeap.add(15);
        maxHeap.add(4);
        maxHeap.add(7);
        maxHeap.add(11);
        System.out.println(maxHeap.peek());
    }
}
