package stack_queue_hashmap;

public class CustomHashmap {
	public static void main(String[] args) {
		MyHashMap<String, Integer> studentGrades = new MyHashMap<>(10);

		// Insert
		System.out.println("--- Inserting Data ---");
		studentGrades.put("Alice", 90);
		studentGrades.put("Bob", 85);
		studentGrades.put("Charlie", 92);
		studentGrades.put("Diana", 88);
		System.out.println("Size after insertions: " + studentGrades.size());

		// Get
		System.out.println("\n--- Retrieving Data ---");
		System.out.println("Alice's Grade: " + studentGrades.get("Alice"));
		System.out.println("Bob's Grade: " + studentGrades.get("Bob"));

		// Update
		System.out.println("\n--- Updating Data ---");
		System.out.println("Old Charlie's Grade: " + studentGrades.get("Charlie"));
		studentGrades.put("Charlie", 95); // Overwrites 92
		System.out.println("New Charlie's Grade: " + studentGrades.get("Charlie"));

		// Delete
		System.out.println("\n--- Deleting Data ---");
		studentGrades.remove("Bob");
		System.out.println("Bob's Grade after removal: " + studentGrades.get("Bob"));
		System.out.println("Final Size: " + studentGrades.size());

		// Handle Non-existent Keys
		System.out.println("\n--- Edge Case ---");
		System.out.println("Grade for 'Eve' (not in map): " + studentGrades.get("Eve"));
	}
}

class MyHashMap<K, V> {
	private class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node<K, V>[] buckets;
	private int capacity;
	private int size;

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.buckets = new Node[capacity];
		this.size = 0;
	}

	private int getBucketIndex(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public void put(K key, V value) {
		int index = getBucketIndex(key);
		Node<K, V> head = buckets[index];

		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		Node<K, V> newNode = new Node<>(key, value);
		newNode.next = buckets[index];
		buckets[index] = newNode;
		size++;
	}

	public V get(K key) {
		int index = getBucketIndex(key);
		Node<K, V> head = buckets[index];

		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public void remove(K key) {
		int index = getBucketIndex(key);
		Node<K, V> head = buckets[index];
		Node<K, V> prev = null;

		while (head != null) {
			if (head.key.equals(key)) {
				if (prev != null) {
					prev.next = head.next;
				} else {
					buckets[index] = head.next;
				}
				size--;
				return;
			}
			prev = head;
			head = head.next;
		}
	}

	public int size() {
		return size;
	}
}