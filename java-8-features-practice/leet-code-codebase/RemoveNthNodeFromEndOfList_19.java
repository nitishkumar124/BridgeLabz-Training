package week6;

public class RemoveNthNodeFromEndOfList_19 {

	public static void main(String[] args) {
		ListNode fifth = new ListNode(5, null);
		ListNode fourth = new ListNode(4, fifth);
		ListNode third = new ListNode(3, fourth);
		ListNode second = new ListNode(2, third);
		ListNode head = new ListNode(1, second);

		head = removeNthFromEnd(head, 3);

		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}

		if (n == len)
			return head.next;

		int pos = len - n;
		temp = head;
		len = 1;
		while (len < pos) {
			len++;
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
