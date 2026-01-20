package week3.custom_browser;

import java.util.Stack;

public class CustomBrowser {
	public static void main(String[] args) {
		BrowserBuddy browser = new BrowserBuddy("google.com");

		browser.visit("github.com");
		browser.visit("stackoverflow.com");

		browser.goBack();
		browser.goForward();

		browser.closeTab();
		browser.showStatus();

		browser.restoreTab();
		browser.showStatus();
	}
}