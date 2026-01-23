package collections.queue_interface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);

		System.out.println("Original Queue: " + queue);
		reverseQueue(queue);
		System.out.println("Reversed Queue: " + queue);
	}

	public static void reverseQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();

		while (!queue.isEmpty()) {
			stack.push(queue.remove());
		}

		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
}