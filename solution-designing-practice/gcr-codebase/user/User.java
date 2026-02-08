package user;
import observer.Observer;

public interface User extends Observer {
	void showRole();
	String getName();
}
