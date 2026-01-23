package collections.queue_interface;

import java.util.Arrays;

class CircularBuffer {
	private int[] buffer;
	private int head = 0;
	private int tail = 0;
	private int size = 0;
	private int capacity;

	public CircularBuffer(int capacity) {
		this.capacity = capacity;
		this.buffer = new int[capacity];
	}

	public void insert(int value) {

		if (size == capacity) {
			head = (head + 1) % capacity;
		} else {
			size++;
		}

		buffer[tail] = value;
		tail = (tail + 1) % capacity;
	}

	public void display() {
		System.out.print("Buffer: [");
		for (int i = 0; i < size; i++) {

			int index = (head + i) % capacity;
			System.out.print(buffer[index] + (i == size - 1 ? "" : ", "));
		}
		System.out.println("]");
	}
}

public class CircularBufferSimulation {
	public static void main(String[] args) {
		CircularBuffer cb = new CircularBuffer(3);

		cb.insert(1);
		cb.insert(2);
		cb.insert(3);
		cb.display();

		System.out.println("Inserting 4 (should overwrite 1)...");
		cb.insert(4);
		cb.display();

		System.out.println("Inserting 5 (should overwrite 2)...");
		cb.insert(5);
		cb.display();
	}
}