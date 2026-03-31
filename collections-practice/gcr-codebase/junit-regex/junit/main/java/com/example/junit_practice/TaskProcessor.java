package com.example.junit_practice;

public class TaskProcessor {
	public String longRunningTask() throws InterruptedException {

		Thread.sleep(3000);
		return "Task Completed";
	}
}