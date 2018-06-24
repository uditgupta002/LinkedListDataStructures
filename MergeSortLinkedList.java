
/* Merge sort for linked lists
 * 
 * Takes O(nlogn) time in worst case.
 * 
 * The sortedMerge procedure merges two sorted lists recursively.
 * findMiddle gives the first middle element int the passed list.
 * mergeSort procedure recursively builds the sorted lists from the left and right sub lists.
 * 
 * 
 * 
 * */

public class MergeSortLinkedList {

	public static void main(String[] args) {
		Node next = null, tail = null;

		Node head = new Node(10);
		next = head.setNext(new Node(9));
		next = next.setNext(new Node(8));
		next = next.setNext(new Node(7));
		next = next.setNext(new Node(6));
		next = next.setNext(new Node(5));
		next = next.setNext(new Node(4));
		next = next.setNext(new Node(3));
		next = next.setNext(new Node(2));
		tail = next.setNext(new Node(1));
		tail.setNext(null);

		head.printList();
		head = mergeSort(head);
		head.printList();
	}

	public static Node mergeSort(Node head) {

		if (head == null || head.next == null)
			return head;

		Node middle = findMiddle(head);
		Node rightHead = middle.next;

		middle.next = null;

		// if(head != null) head.printList();
		// if(rightHead != null) rightHead.printList();

		Node leftList = mergeSort(head);
		Node rightList = mergeSort(rightHead);
		return sortedMerge(leftList, rightList);

	}

	public static Node sortedMerge(Node leftHead, Node rightHead) {
		Node result;

		if (leftHead == null)
			return rightHead;

		if (rightHead == null)
			return leftHead;

		if (leftHead.data <= rightHead.data) {
			result = leftHead;
			result.next = sortedMerge(leftHead.next, rightHead);
		} else {
			result = rightHead;
			result.next = sortedMerge(leftHead, rightHead.next);
		}
		return result;
	}

	public static Node findMiddle(Node head) {

		if (head == null)
			return head;

		Node fastPtr = head.next;
		Node slowPtr = head;

		while (fastPtr != null) {

			fastPtr = fastPtr.next;
			if (fastPtr != null) {
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
			}
		}
		return slowPtr;
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}

	public Node setNext(Node next) {
		this.next = next;
		return next;
	}

	public void printList() {
		Node ptr = this;
		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}
