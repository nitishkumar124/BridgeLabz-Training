package level1;

public class RestaurantSystem {
	public static void main(String[] args) {
		Worker c = new Chef();
        Worker w = new Waiter();

        c.performDuties();
        w.performDuties();
	}
}
interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;
}

class Chef extends Person implements Worker {
    public void performDuties() {
        System.out.println("Chef cooks food");
    }
}

class Waiter extends Person implements Worker {
    public void performDuties() {
        System.out.println("Waiter serves food");
    }
}