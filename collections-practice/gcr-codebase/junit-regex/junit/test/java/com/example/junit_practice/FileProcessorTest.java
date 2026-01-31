package com.example.junit_practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;

class FileProcessorTest {

	private final FileProcessor processor = new FileProcessor();

	@TempDir
	Path tempDir;

	@Test
	void testWriteAndReadSuccess() throws IOException {
		Path filePath = tempDir.resolve("test.txt");
		String filename = filePath.toString();
		String content = "Hello, JUnit!";

		processor.writeToFile(filename, content);

		assertTrue(filePath.toFile().exists(), "File should exist after writing");

		assertEquals(content, processor.readFromFile(filename), "Read content should match written content");
	}

	@Test
	void testReadNonExistentFileThrowsException() {
		String fakeFile = tempDir.resolve("non_existent.txt").toString();

		assertThrows(IOException.class, () -> {
			processor.readFromFile(fakeFile);
		});
	}
}