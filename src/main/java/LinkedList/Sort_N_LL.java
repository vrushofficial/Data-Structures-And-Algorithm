package LinkedList;

import java.util.*;

/**
 * modified by @author Vrushabh Joshi last on 26-11-2020 08:47
 */
public class Sort_N_LL {

    static class LinkedList{
        Node head;
        static class Node implements Comparable<Node>{
            int val;
            Node next;
            Node(int val)
            {
                this.val=val;
                this.next=null;
            }

            @Override
            public int compareTo(Node node) {
                return this.val-node.val;
            }
        }
        void printLL(Node head)
        {
            while (head!=null)
            {
                System.out.println(head.val);
                head=head.next;
            }
        }

        /**
         * merge sorted lists
         * @param arr array of lists
         * @param k no. of lists
         * @return sorted LL head
         */
        public static Node mergeIt(Node arr[], int k)
        {
            Node result = null,
            last = null;

            PriorityQueue<Node> pq = new PriorityQueue<>();

            // push the head nodes of all
            for (int i = 0; i < k; i++)
                if (arr[i] != null)
                    pq.add(arr[i]);

            while (!pq.isEmpty()) {
                Node top = pq.peek();
                pq.remove();

                //add a node which is just next to the removed one from respective list to PQ
                if (top.next != null)
                    pq.add(top.next);

                // if result list is empty
                if (result == null) {
                    result = top;
                    last = top;
                }
                else {
                    last.next = top;
                    last = top;
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {

        LinkedList.Node arr[] = new LinkedList.Node [3];

        arr[0] = new LinkedList.Node(1);
        arr[0].next = new LinkedList.Node(3);
        arr[0].next.next = new LinkedList.Node(5);
        arr[0].next.next.next = new LinkedList.Node(7);
        arr[1] = new LinkedList.Node (2);
        arr[1].next = new LinkedList.Node (4);
        arr[1].next.next = new LinkedList.Node (6);
        arr[1].next.next.next = new LinkedList.Node (8);

        arr[2] = new LinkedList.Node (0);
        arr[2].next = new LinkedList.Node (9);
        arr[2].next.next = new LinkedList.Node (10);
        arr[2].next.next.next = new LinkedList.Node (11);
        LinkedList l1 =new LinkedList();
        l1.printLL(l1.mergeIt(arr,2));

    }


}
