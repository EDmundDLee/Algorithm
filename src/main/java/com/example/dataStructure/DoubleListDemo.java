package com.example.dataStructure;

/**
 * @author lijiaxu
 * @Description
 * @date 2024/7/24 16:01
 */
public class DoubleListDemo {


   public static DoublyListNode createDoublyLinkedList(int[] arr) {
        if (arr==null ||arr.length ==0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);

        DoublyListNode cur = head;
        //for循环创建双链表
        for (int i=1;i<arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            cur.next = newNode;
            newNode.prev = cur;
            cur = cur.next;
        }

        return  head;
    }

//    //遍历 查/改
//    public static void main(String[] args) {
//        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
//        //定位尾部
//        DoublyListNode tail = head;
//        for (DoublyListNode p = head;p!=null; p=p.next) {
//            System.out.println(p.val);
//        }
//
//        while (tail!=null &&tail.next!=null) {
//            tail = tail.next;
//        }
//        for (DoublyListNode p = tail;p!=null; p=p.prev) {
//            System.out.println(p.val);
//        }
//
//    }

//    //头部新增
//    public static void main(String[] args) {
//        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
//        DoublyListNode doublyListNode = new DoublyListNode(999);
//        doublyListNode.next = head;
//        head.prev = doublyListNode;
//
//        for (DoublyListNode p = doublyListNode;p!=null; p=p.next) {
//            System.out.println(p.val);
//        }
//    }

//    //尾部新增
//    public static void main(String[] args) {
//        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
//        DoublyListNode doublyListNode = new DoublyListNode(999);
//        DoublyListNode temp = head;
//        while (head!=null &&temp.next!=null) {
//            temp = temp.next;
//        }
//        temp.next = doublyListNode;
//        doublyListNode.prev = temp;
//
//        for (DoublyListNode p = head;p!=null; p=p.next) {
//            System.out.println(p.val);
//        }
//    }

//    //中间新增
//    public static void main(String[] args) {
//        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
//        DoublyListNode doublyListNode = new DoublyListNode(999);
//        DoublyListNode temp = head;
//        for(int i =0; i<2; i++) {
//            temp =temp.next;
//        }
//        doublyListNode.next = temp.next;
//        temp.next = doublyListNode;
//        doublyListNode.prev = temp;
//
//
//        for (DoublyListNode p = head;p!=null; p=p.next) {
//            System.out.println(p.val);
//        }
//    }

//    //删除一个节点
//    public static void main(String[] args) {
//        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
//        DoublyListNode temp = head;
//
//        for (int i=0; i<1; i++) {
//            temp =temp.next;
//        }
//
//        temp.next = temp.next.next;
//
//        temp.next.prev = temp;
//
//         for (DoublyListNode p = head;p!=null; p=p.next) {
//            System.out.println(p.val);
//        }
//
//    }

    //删除头部节点
    public static void main(String[] args) {
        DoublyListNode head = createDoublyLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        DoublyListNode deletePoint = head;
        head =head.next;
        head.prev = null;
        deletePoint.next = null;


        for (DoublyListNode p = head; p!=null; p=p.next) {
            System.out.println(p.val);
        }

    }
}
