package week4.part2;

import java.util.*;

public class IntersectionOfTwoLinkedLists_160 {

	public static void main(String[] args) {
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);

		ListNode headB = new ListNode(5);
		headB.next = new ListNode(0);
		headB.next.next = new ListNode(1);
		headB.next.next.next = headA.next.next; 

		ListNode intersectionNode = getIntersectionNode(headA, headB);
		if (intersectionNode != null) {
			System.out.println("Intersection at node with value: " + intersectionNode.val);
		} else {
			System.out.println("No intersection.");
		}
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = len(headA), lenB = len(headB);
		ListNode tempA = headA, tempB = headB;
		while (lenA < lenB) {
			lenB--;
			tempB = tempB.next;
		}
		while (lenB < lenA) {
			lenA--;
			tempA = tempA.next;
		}

		while (tempA != null && tempB != null) {
			if (tempA == tempB)
				return tempA;
			tempA = tempA.next;
			tempB = tempB.next;
		}

		return null;
	}

	public static int len(ListNode head) {
		ListNode temp = head;
		int l = 0;
		while (temp != null) {
			l++;
			temp = temp.next;
		}
		return l;
	}
}
