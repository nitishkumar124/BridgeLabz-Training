package week4;

public class AddTwoNumbers_2 {

	public static void main(String[] args) {
		AddTwoNumbers_2 solution = new AddTwoNumbers_2();

		ListNode l1 = solution.new ListNode(2);
		l1.next = solution.new ListNode(4);
		l1.next.next = solution.new ListNode(3); // l1: 2 -> 4 -> 3

		ListNode l2 = solution.new ListNode(5);
		l2.next = solution.new ListNode(6);
		l2.next.next = solution.new ListNode(4); // l2: 5 -> 6 -> 4

		ListNode result = solution.addTwoNumbers(l1, l2);

		System.out.print("Resultant Linked List: ");
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sum = new ListNode();
		ListNode temp = sum;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int x = l1.val + l2.val + carry;
			int a = x % 10;
			carry = x / 10;
			temp.next = new ListNode(a);
			temp = temp.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int x = l1.val + carry;
			int a = x % 10;
			carry = x / 10;
			temp.next = new ListNode(a);
			temp = temp.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int x = l2.val + carry;
			int a = x % 10;
			carry = x / 10;
			temp.next = new ListNode(a);
			temp = temp.next;
			l2 = l2.next;
		}
		if (carry != 0)
			temp.next = new ListNode(carry);
		return sum.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
