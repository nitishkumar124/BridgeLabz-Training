package com.example.junit_practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class TaskProcessorTest {

	private final TaskProcessor processor = new TaskProcessor();

	@Test
	@Timeout(value = 2, unit = TimeUnit.SECONDS)
	void testLongRunningTaskTimeout() throws InterruptedException {
		String result = processor.longRunningTask();
		assertEquals("Task Completed", result);
	}
}