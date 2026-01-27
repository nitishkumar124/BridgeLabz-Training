package java_exceptions;


public class MultipleCatchBlocks {
	public static void main(String[] args) {
		try {
			int[] arr = { 10, 20, 30, 40, 50 };
			int index = 7;

			System.out.println("Value at index " + index + ": " + arr[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index is out of bounds");
		} catch (NullPointerException e) {
			System.out.println("Array is null");
		}
	}
}
