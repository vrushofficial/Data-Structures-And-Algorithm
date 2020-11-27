/*Write a function that checks whether a given Linked List contains loop and
if loop is present then removes the loop and returns true*/
package LinkedList;

/**
 * modified by @author Vrushabh Joshi last on 27-11-2020 14:40
 */
public class DetectCycle {

    static Node head;
    class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    /*
        detects LL contains any circular dependency
        if : then return starting point of circular loop
        Solution : Hare & Tortoise Approch (floyd's algo)
        */
    public static Node detectReturnCycle()
    {
        Node hare, tortoise;
        hare=tortoise= head;
        boolean found=false;
        Node loopStart=null;

        while (hare.next != null && tortoise != null && tortoise.next != null)
        {
            hare= hare.next;
            tortoise= tortoise.next.next;
            if(hare ==tortoise)
            {
                found=true;
                break;
            }
        }
        if (found)
        {
            Node first= head;
            while (first != hare)
            {
                first= first.next;
                hare=hare.next;
            }
            loopStart=hare;
        }
        return loopStart;
    }

    public static void main(String[] args) {
        DetectCycle list = new DetectCycle();

        list.push(7);
        list.push(1);
        list.push(3);
        list.push(2);
        list.head.next.next.next.next = list.head.next;
        System.out.println(detectReturnCycle().data);
    }
}



