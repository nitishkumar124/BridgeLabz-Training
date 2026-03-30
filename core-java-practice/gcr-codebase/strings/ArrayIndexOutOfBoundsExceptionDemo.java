package level1;

import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionDemo {

	public static void getName(String[] arr, int index) {
		System.out.print("name at index " + index + " : " + arr[index]);
	}

	public static void handleException(String[] arr, int index) {
		try {
			getName(arr, index);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("exception handled");
		} catch (RuntimeException e) {
			System.out.print("generic runtime exception");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 5;
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			System.out.print("enter name " + (i + 1) + " : ");
			arr[i] = sc.next();
		}
		
		handleException(arr, 10);
	}

}
