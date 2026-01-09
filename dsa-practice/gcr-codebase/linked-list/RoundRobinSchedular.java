package linked_list;

import java.util.*;

public class RoundRobinSchedular {
	public static void main(String[] args) {
		CPUScheduler scheduler = new CPUScheduler();
		scheduler.addProcess(1, 10, 1);
		scheduler.addProcess(2, 5, 2);
		scheduler.addProcess(3, 8, 3);

		scheduler.simulate(4); 
	}
}

class Process {
	int id;
	int burstTime;
	int remainingTime;
	int priority;
	int arrivalTime = 0;
	int completionTime, turnAroundTime, waitingTime;
	Process next;

	public Process(int id, int burstTime, int priority) {
		this.id = id;
		this.burstTime = burstTime;
		this.remainingTime = burstTime;
		this.priority = priority;
	}
}

class CPUScheduler {
	private Process head = null;
	private Process tail = null;
	private List<Process> completedProcesses = new ArrayList<>();

	// Add process at the end
	public void addProcess(int id, int burstTime, int priority) {
		Process newP = new Process(id, burstTime, priority);
		if (head == null) {
			head = tail = newP;
			tail.next = head;
		} else {
			tail.next = newP;
			tail = newP;
			tail.next = head;
		}
	}

	// Simulate Round-Robin Scheduling
	public void simulate(int timeQuantum) {
		if (head == null)
			return;

		int currentTime = 0;
		Process curr = head;
		Process prev = tail;

		System.out.println("\n--- Starting Round Robin Execution ---");

		while (head != null) {
			System.out.println(
					"Time " + currentTime + ": Executing P" + curr.id + " (Remaining: " + curr.remainingTime + ")");

			if (curr.remainingTime > timeQuantum) {
				currentTime += timeQuantum;
				curr.remainingTime -= timeQuantum;
				prev = curr;
				curr = curr.next;
			} else {
				currentTime += curr.remainingTime;
				curr.remainingTime = 0;
				curr.completionTime = currentTime;
				curr.turnAroundTime = curr.completionTime - curr.arrivalTime;
				curr.waitingTime = curr.turnAroundTime - curr.burstTime;

				completedProcesses.add(curr);
				System.out.println("Time " + currentTime + ": P" + curr.id + " Completed.");

				if (curr == head && curr == tail) {
					head = tail = null;
				} else {
					prev.next = curr.next;
					if (curr == head)
						head = prev.next;
					if (curr == tail)
						tail = prev;
					curr = prev.next;
				}
			}
			displayStatus();
		}
		calculateMetrics();
	}

	// Display status of the circular queue
	public void displayStatus() {
		if (head == null) {
			System.out.println("Queue: Empty");
			return;
		}
		System.out.print("Queue Status: ");
		Process temp = head;
		do {
			System.out.print("P" + temp.id + "(" + temp.remainingTime + ") -> ");
			temp = temp.next;
		} while (temp != head);
		System.out.println("(Back to P" + head.id + ")");
	}

	// Calculate Average Waiting and Turnaround Time
	private void calculateMetrics() {
		double totalWT = 0, totalTAT = 0;
		System.out.println("\n--- Final Metrics ---");
		System.out.println("ID\tBurst\tCompletion\tTAT\tWT");
		for (Process p : completedProcesses) {
			totalWT += p.waitingTime;
			totalTAT += p.turnAroundTime;
			System.out.println(p.id + "\t" + p.burstTime + "\t" + p.completionTime + "\t\t" + p.turnAroundTime + "\t"
					+ p.waitingTime);
		}
		System.out.printf("\nAverage Turnaround Time: %.2f", (totalTAT / completedProcesses.size()));
		System.out.printf("\nAverage Waiting Time: %.2f\n", (totalWT / completedProcesses.size()));
	}
}
