package level1;

import java.util.*;

public class AnimalHierarchy {

	public static void main(String[] args) {
		Animal animal = new Animal();
		Dog dog = new Dog();
		Bird bird = new Bird();
		Cat cat = new Cat();

		animal.makeSound();
		dog.makeSound();
		bird.makeSound();
		cat.makeSound();
	}
}

class Animal {
	String name;
	int age;

	void makeSound() {
		System.out.println("Animal makes sound.");
	}
}

class Dog extends Animal {
	@Override
	void makeSound() {
		System.out.println("Dog barks.");
	}

}

class Cat extends Animal {
	@Override
	void makeSound() {
		System.out.println("Cat meows.");
	}

}

class Bird extends Animal {
	@Override
	void makeSound() {
		System.out.println("Bird Chirps.");
	}

}
