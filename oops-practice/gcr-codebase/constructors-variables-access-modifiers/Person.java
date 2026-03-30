package level1;

public class Person {
	
	String name;
	int age;
	String city;
	
	Person(String name, int age, String city){
		this.name = name;
		this.age = age;
		this.city = 	city;
	}

	Person(Person p){
		this.name = p.name;
		this.age = p.age;
		this.city = p.city;
	}

	public static void main(String[] args) {
		
		Person p1 = new Person("Aryansh", 24, "Mathura");
		Person p2 = new Person(p1);
	}
}

