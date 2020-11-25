//Merge sort with linkedlist
package LinkedList;

/**
 * modified by @author Vrushabh Joshi last on 25-11-2020 7:42
 */
public class MergeSortLL {
	Node head = null; 
	static class Node {
		int val; 
		Node next; 
		public Node(int val)
		{ 
			this.val = val;
			next=null;
		} 
	} 

	Node merge(Node a, Node b)
	{ 
		Node result = null; 
		if (a == null)
			return b; 
		if (b == null) 
			return a; 

		//from first list
		if (a.val <= b.val) {
			result = a;
			//move comparable pointer of first list
			result.next = merge(a.next, b);
		}
		//Or from first list
		else {
			result = b;
			//move comparable pointer of second list
			result.next = merge(a, b.next);
		} 
		return result; 
	} 

	Node mergeSort(Node h) 
	{ 
		if (h == null || h.next == null) {
			return h; 
		} 

		Node middle = getMiddle(h);
		Node nextofmiddle = middle.next; 

		//unlink middle from Nodes
		middle.next = null;

		// Apply mergeSort on left list 
		Node left = mergeSort(h); 

		// Apply mergeSort on right list 
		Node right = mergeSort(nextofmiddle); 

		// Merge the left and right lists 
		Node sortedlist = merge(left, right);
		return sortedlist; 
	} 

	public static Node getMiddle(Node head)
	{
		// move hare 1 Node and tortoise 2 Node at time
		//when hare reach end tortoise'll be at middle
		if (head == null) 
			return head; 
		Node hare = head, tortoise = head;

		while (hare.next != null && hare.next.next != null) {
			tortoise = tortoise.next;
			hare = hare.next.next;
		} 
		return tortoise;
	} 

	void push(int new_data) 
	{ 
 		Node new_Node = new Node(new_data);
		new_Node.next = head;
		head = new_Node;
	}

	void printLL(Node head)
	{
		while (head!=null)
		{
			System.out.println(head.val);
			head=head.next;
		}
	}

	public static void main(String[] args) 
	{

		MergeSortLL li = new MergeSortLL();
		li.push(34);
		li.push(8);
		li.push(25);
		li.push(27);
		li.push(69);
		li.push(1);

		li.head = li.mergeSort(li.head);
		li.printLL(li.head);
	} 
}