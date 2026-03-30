package linked_list;

import java.util.*;

public class TextEditorApp {
	public static void main(String[] args) {
		TextEditor editor = new TextEditor();

		editor.addAction("Hello");
		editor.addAction("Hello World");
		editor.addAction("Hello World!");

		editor.displayCurrentContent();

		editor.undo();
		editor.displayCurrentContent();

		editor.undo();
		editor.displayCurrentContent();

		editor.redo();
		editor.displayCurrentContent();

		
		editor.addAction("Hello Java");
		editor.redo(); 
		editor.displayCurrentContent();
	}
}

class TextState {
	String content;
	TextState prev;
	TextState next;

	public TextState(String content) {
		this.content = content;
		this.prev = null;
		this.next = null;
	}
}

class TextEditor {
	private TextState head;
	private TextState currentState;
	private int historySize;
	private final int MAX_HISTORY = 10;

	public TextEditor() {
		// Initial empty 
		head = new TextState("");
		currentState = head;
		historySize = 1;
	}

	// Add a new text
	public void addAction(String newContent) {
		TextState newState = new TextState(newContent);

		// When a new action is performed, clear "redo"
		currentState.next = newState;
		newState.prev = currentState;

		// Move current state to the new node
		currentState = newState;
		historySize++;

		// Limit history size
		if (historySize > MAX_HISTORY) {
			head = head.next;
			head.prev = null;
			historySize--;
		}
		System.out.println("Action Saved: " + newContent);
	}

	// Undo functionality
	public void undo() {
		if (currentState.prev != null) {
			currentState = currentState.prev;
			System.out.println("Undo performed.");
		} else {
			System.out.println("Nothing to undo.");
		}
	}

	// Redo functionality
	public void redo() {
		if (currentState.next != null) {
			currentState = currentState.next;
			System.out.println("Redo performed.");
		} else {
			System.out.println("Nothing to redo.");
		}
	}

	// Display current state
	public void displayCurrentContent() {
		System.out.println("Current Text: \"" + currentState.content + "\"");
	}
}
