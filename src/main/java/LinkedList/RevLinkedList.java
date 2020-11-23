//reverse every k nodes in kth sized group (where k is an input to the function).
//https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
package LinkedList;

/**
 * modified by @author Vrushabh Joshi last on 23-11-2020 10:24
 */
public class RevLinkedList {
        Node head;
        RevLinkedList revLinkedList;
        class Node
        {
            int val;
            Node next;
            Node(int val)
            {
                this.val=val;
                next=null;
            }
        }

    void initList()
    {
        this.revLinkedList = new RevLinkedList();
        revLinkedList.head=head;
        head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        head.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        five.next=six;
        revLinkedList.head=head;
    }

    Node reverseList(Node head, int group)
    {
        Node current = head; Node next = null; Node prev = null;
        int i = 0;

        //reverse till counter reaches to group value
        //recall fun when it reaches and amend to already found list
        while (i < group && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        if (next != null)
            head.next = reverseList(next, group);
        return prev;
    }
    void printLL(Node head)
    {
        while (head!=null)
        {
            System.out.println(head.val);
            head=head.next;
        }
    }
    public static void main(String[] args) {
        RevLinkedList linkedList = new RevLinkedList();
        linkedList.initList();
        linkedList.printLL(linkedList.reverseList(linkedList.head,3));
    }
}
