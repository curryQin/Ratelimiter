package curry.qin.NodeReverse;

/**
 * @author curry
 * @version V1.0
 * @Package curry.qin
 * @date 2020/3/31 17:20
 * @Copyright © 2019-2020 yamibuy
 */
public class NodeReverse {
//    public static void main(String[] args) {
//        Node node5 = new Node("5", null);
//        Node node4 = new Node("4", node5);
//        Node node3 = new Node("3", node4);
//        Node node2 = new Node("2", node3);
//        Node node1 = new Node("1", node2);
//        Node ss = reverseNode(node1);
//        while (ss != null){
//            System.out.print(ss.getValue()+"->");
//            ss = ss.getNext();
//        }
//
//    }
    public static Node reverseNode(Node head){
        if (head.next == null){
            return head;
        }
        Node next = head.next;
        Node endNode = reverseNode(next);
        next.next = head;
        head.next = null;
        return endNode;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=null;
        reverseBetween(node1,2,4);
        while (node1 != null){
            System.out.print(node1.val+"-》");
            node1 = node1.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int s1 = listNodeToInt(l1);
//        int s2 = listNodeToInt(l2);
//        int sum = s1 + s2;
//
//        return null;
//    }


    private static int listNodeToInt(ListNode l1){
        int s1 = 0;
        int count = 1;
        while (l1 != null){
            if(count == 1){
                s1 = l1.val;
            }else {
                s1 = l1.val*count+s1;
            }
            l1 = l1.next;
            count = count*10;
        }
        return s1;
    }
    public ListNode removeElements(ListNode head, int val){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null || curr.next != null){
            if(curr.val == val){
                if(curr.next.next != null){
                    curr = curr.next.next;
                    prev = curr.next;
                    prev.next = curr;
                }else {
                    return head;
                }
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
