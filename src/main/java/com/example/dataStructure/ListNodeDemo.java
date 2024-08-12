package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description 单链表基本操作
 * @date 2024/7/24 09:22
 */
public class ListNodeDemo {

    public static ListNode createListNode(int[] arr) {
        if(arr==null||arr.length==0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i =1; i<arr.length;i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;

        }
        return head;
    }

    //查找
//    public static void main(String[] args) {
//        ListNode listNode = createListNode(new int[]{1, 2, 3, 4, 5});
//        for (ListNode p =listNode; p!=null;p = p.next) {
//            System.out.println(p.val);
//
//        }
//    }


//    //头部增加
//    public static void main(String[] args) {
//        ListNode listNode = createListNode(new int[]{1, 2, 3, 4, 5});
//        //头部插入新元素
//        ListNode newNode = new ListNode(11);
//        newNode.next = listNode;
//        listNode = newNode;
//        for (ListNode p =listNode; p!=null;p = p.next) {
//            System.out.println(p.val);
//        }
//    }


//
//
//    //中间插入
//    public static void main(String[] args) {
//        ListNode head = createListNode(new int[]{1, 2, 3, 4, 5, 6});
//        ListNode p = head;
//        for (int i=0; i<2; i++) {
//            p = p.next;
//        }
//        ListNode newNode = new ListNode(666);
//        newNode.next = p.next;
//        p.next = newNode;
//        for (ListNode i = head; i!=null; i =i.next) {
//            System.out.println(i.val);
//        }
//    }

//    //删除一个节点
//    public static void main(String[] args) {
//        ListNode head = createListNode(new int[]{1, 2, 3, 4, 5, 6});
//        ListNode p = head;
//        for (int i=0; i<2; i++) {
//            p = p.next;
//        }
//        p.next = p.next.next;
//        for (ListNode i = head; i!=null; i =i.next) {
//            System.out.println(i.val);
//        }
//    }

//    //删除尾部一个节点
//    public static void main(String[] args) {
//        ListNode head = createListNode(new int[]{1, 2, 3, 4, 5, 6});
//        ListNode p = head;
//
//        while (p.next.next!=null) {
//            p = p.next;
//        }
//
//        p.next = null;
//
//        for (ListNode i = head; i!=null; i=i.next) {
//            System.out.println(i.val);
//        }
//    }

    //删除头部一个节点
    public static void main(String[] args) {
        ListNode head = createListNode(new int[]{1, 2, 3, 4, 5, 6});
       head = head.next;
        for (ListNode i = head; i!=null; i=i.next) {
            System.out.println(i.val);
        }
    }
}
