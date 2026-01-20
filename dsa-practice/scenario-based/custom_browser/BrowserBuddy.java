package week3.custom_browser;
import java.util.Stack;


public class BrowserBuddy {
	private Page current;
	private Stack<String> closedTabs;

	public BrowserBuddy(String homePage) {
		this.current = new Page(homePage);
		this.closedTabs = new Stack<>();
		System.out.println("Browser started. Home: " + homePage);
	}

	public void visit(String url) {
		Page newPage = new Page(url);
		current.next = newPage;
		newPage.prev = current;
		current = newPage;
		System.out.println("Visited: " + url);
	}

	public void goBack() {
		if (current.prev != null) {
			current = current.prev;
			System.out.println("Back to: " + current.url);
		} else {
			System.out.println("⚠️ No back history.");
		}
	}

	public void goForward() {
		if (current.next != null) {
			current = current.next;
			System.out.println("Forward to: " + current.url);
		} else {
			System.out.println("⚠️ No forward history.");
		}
	}

	public void closeTab() {
		System.out.println("Closing tab: " + current.url);
		closedTabs.push(current.url);

		if (current.prev != null) {
			current = current.prev;
			current.next = null;
		}
	}

	public void restoreTab() {
		if (!closedTabs.isEmpty()) {
			String restoredUrl = closedTabs.pop();
			System.out.print("Restoring... ");
			visit(restoredUrl);
		} else {
			System.out.println("⚠️ No tabs to restore.");
		}
	}

	public void showStatus() {
		System.out.println("📍 Current Page: " + current.url);
	}
}