package level1;

public class Circle {
	double radius;

	Circle(double radius) {
		this.radius = radius;
	}

	void displayArea() {
		double area = Math.round(Math.PI * Math.pow(radius, 2));
		System.out.println("Area of circle: " + area);
		
	}
	
	void displayCircumference() {
		double circumference = Math.round(2 * Math.PI * radius);
		System.out.println("Circumference of circle: " + circumference);
		
	}

	public static void main(String[] args) {
		Circle myCircle = new Circle(2.5);
		myCircle.displayArea();
		myCircle.displayCircumference();
	}
}
