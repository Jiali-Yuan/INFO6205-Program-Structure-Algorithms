/* Given a sorted linked list, delete all duplicates such that each element appear only once.
 */

import java.util.*;
class RemoventhNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		add(head, 1);
		add(head, 2);
		add(head, 3);
		add(head, 4);
		int n = 2;
		ListNode temp = head;
		ListNode test = removeNthNode(temp, n);
		System.out.println("After remove:");
		printList(test);
	}
	
	public static ListNode removeNthNode (ListNode head, int n) {
		if (head == null) return head;
		ListNode node = head;
		int length = 0;
		while (node != null) {
			length += 1;
			node = node.next;
		}
		
		ListNode dummy = new ListNode(10);
		dummy.next = head;
		ListNode cur = dummy;
		int count = 0;
		while (cur != null) {
			if (count == length - n) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
			count += 1;	
		}
		return dummy.next;
	}
	
	public static void add(ListNode node, int val){
		ListNode cur = node;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new ListNode(val);
	}
	
	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println("null");
	}
}

class ListNode {
	ListNode next;
	int val;
	public ListNode(int val) {
		this.val = val;
	}
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
