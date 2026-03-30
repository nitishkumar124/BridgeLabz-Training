package stack_queue_hashmap;

import java.util.*;

public class QueueUsingStack {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue()); 
		System.out.println(queue.peek()); 
		System.out.println(queue.isEmpty()); 
	}
}

class MyQueue {
	private Stack<Integer> stackIn; // For enqueue
	private Stack<Integer> stackOut; // For dequeue

	public MyQueue() {
		stackIn = new Stack<>();
		stackOut = new Stack<>();
	}

	public void enqueue(int x) {
		stackIn.push(x);
	}

	public int dequeue() {
		fillStackOut();
		if (stackOut.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return stackOut.pop();
	}


	public int peek() {
		fillStackOut();
		if (stackOut.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return stackOut.peek();
	}


	public boolean isEmpty() {
		return stackIn.isEmpty() && stackOut.isEmpty();
	}

	
	private void fillStackOut() {
		if (stackOut.isEmpty()) {
			while (!stackIn.isEmpty()) {
				stackOut.push(stackIn.pop());
			}
		}
	}
}
