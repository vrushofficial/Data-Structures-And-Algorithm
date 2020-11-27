//Clone a linked list with next and random pointer
package LinkedList;
/**
 * modified by @author Vrushabh Joshi last on 27-11-2020 09:54
 */
public class CloneWithRandom {
    static Node head;
    static class Node
    {
        int val;
        Node next;
        Node random;
        Node(int val)
        {
            this.val=val;
            next=null;
            random=null;
        }
    }
    Node push(Node node)
    {
        node.next=head;
        head=node;
        return head;
    }
    void printLL(Node head)
    {
        while (head!=null)
        {
            System.out.println(head.val);
            head=head.next;
        }
    }

    public static void main(String args[])
    {
        CloneWithRandom cloneWithRandom = new CloneWithRandom();
        Node n1=new Node(1);
        head=n1;
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        n1.random=n4;n2.random=n5; n3.random=head; n4.random=n2; n5.random=n3;
        cloneWithRandom.push(n2);
        cloneWithRandom.push(n3);
        cloneWithRandom.push(n4);
        cloneWithRandom.push(n5);
        cloneWithRandom.printLL(cloneWithRandom.cloneIt(head));
    }
    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    Node cloneIt(Node origin)
    {
        Node clonedHead = null;
        while (origin!=null)
        {
            Node eachCloned= new Node(origin.val);
            if (clonedHead==null)
            {
                clonedHead=eachCloned;
            }
            else {
                eachCloned.next = clonedHead;
                clonedHead = eachCloned;
            }
            origin=origin.next;
        }
        clonedHead= reverse(clonedHead);
        Node localCloned=clonedHead;
        while (head!=null)
        {
            //create cloned list of origin
            // point each origin node's next to respective cloned node's head with iteration
            // point each cloned node's random to respective origin node's head with iteration
            //point cloned's head's random to its random(means respective origin in this case)'s to next
            // clonedNode.random= clonedNode.random.random.next
            head.next=localCloned;
            localCloned.random=head;
            localCloned.random=localCloned.random.random.next;
            head=head.next;
            clonedHead=localCloned;
            localCloned=clonedHead.next;
        }
        return clonedHead;
    }
}
