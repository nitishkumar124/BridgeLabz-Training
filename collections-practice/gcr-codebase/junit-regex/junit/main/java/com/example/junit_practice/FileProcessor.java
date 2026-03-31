package com.example.junit_practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {

	public void writeToFile(String filename, String content) throws IOException {
		Files.writeString(Paths.get(filename), content);
	}

	public String readFromFile(String filename) throws IOException {
		Path path = Paths.get(filename);
		if (!Files.exists(path)) {
			throw new IOException("File not found: " + filename);
		}
		return Files.readString(path);
	}
}