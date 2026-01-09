package linked_list;

import java.util.*;

public class TaskSchedular {
	public static void main(String[] args) {
		TaskScheduler scheduler = new TaskScheduler();

		scheduler.addTask(1, "Email Client", 2, "2026-01-10", 1);
		scheduler.addTask(2, "Update Server", 1, "2026-01-09", 2);
		scheduler.addTask(3, "Backup Database", 3, "2026-01-08", 3);

		scheduler.displayAll();

		System.out.println("\nCycling through tasks:");
		scheduler.nextTask();
		scheduler.nextTask();
		scheduler.nextTask();
		scheduler.nextTask();
	}
}

class Task {
	int taskId;
	String taskName;
	int priority;
	String dueDate;
	Task next;

	public Task(int id, String name, int priority, String date) {
		this.taskId = id;
		this.taskName = name;
		this.priority = priority;
		this.dueDate = date;
	}
}

class TaskScheduler {
	private Task head = null;
	private Task tail = null;
	private Task currentView = null;

	// Add Task
	public void addTask(int id, String name, int priority, String date, int pos) {
		Task newTask = new Task(id, name, priority, date);

		if (head == null) {
			head = tail = newTask;
			tail.next = head; 
			currentView = head;
			return;
		}

		if (pos <= 1) {
			newTask.next = head;
			head = newTask;
			tail.next = head; 
			return;
		}

		Task temp = head;
		int currentPos = 1;
		
		while (temp.next != head && currentPos < pos - 1) {
			temp = temp.next;
			currentPos++;
		}

		newTask.next = temp.next;
		temp.next = newTask;
		if (temp == tail) {
			tail = newTask; 
		}
	}

	// Remove Task by ID
	public void removeTask(int id) {
		if (head == null)
			return;

		Task curr = head;
		Task prev = tail;

		do {
			if (curr.taskId == id) {
				if (curr == head && curr == tail) { 
					head = tail = currentView = null;
				} else {
					prev.next = curr.next;
					if (curr == head)
						head = head.next;
					if (curr == tail)
						tail = prev;
					if (curr == currentView)
						currentView = curr.next;
				}
				System.out.println("Task " + id + " removed.");
				return;
			}
			prev = curr;
			curr = curr.next;
		} while (curr != head);

		System.out.println("Task ID not found.");
	}

	// View current task and move to next
	public void nextTask() {
		if (currentView == null) {
			System.out.println("No tasks in scheduler.");
			return;
		}
		System.out.println("Current Task: [" + currentView.taskId + "] " + currentView.taskName);
		currentView = currentView.next; 
	}

	// Display all tasks
	public void displayAll() {
		if (head == null) {
			System.out.println("Scheduler is empty.");
			return;
		}
		Task temp = head;
		System.out.println("\n--- Task List ---");
		do {
			System.out.println("ID: " + temp.taskId + " | Name: " + temp.taskName + " | Priority: " + temp.priority);
			temp = temp.next;
		} while (temp != head);
	}

	// Search by Priority
	public void searchByPriority(int p) {
		if (head == null)
			return;
		Task temp = head;
		boolean found = false;
		do {
			if (temp.priority == p) {
				System.out.println("Match Found: " + temp.taskName + " (ID: " + temp.taskId + ")");
				found = true;
			}
			temp = temp.next;
		} while (temp != head);
		if (!found)
			System.out.println("No tasks with priority " + p);
	}
}
