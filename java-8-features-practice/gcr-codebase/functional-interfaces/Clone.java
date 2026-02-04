package functional_interfaces;

public class Clone implements Cloneable {
	int x = 10;
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public static void main(String[] args) {
		Clone c1 = new Clone();
		try {
			Clone c2 = (Clone) c1.clone();
			System.out.println(c2.x);
		}catch(CloneNotSupportedException e) {
			System.out.println("Cloning not supported");
		}
	}
}
