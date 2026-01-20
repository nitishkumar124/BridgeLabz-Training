package week3.delivery_system;

public class Stage {
	String name;
	Stage next;

	public Stage(String name) {
		this.name = name;
		this.next = null;
	}
}