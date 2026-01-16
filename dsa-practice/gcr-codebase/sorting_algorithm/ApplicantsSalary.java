package sorting_algorithm;

public class ApplicantsSalary {
	static void heap(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest])
			largest = left;

		if (right < n && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heap(arr, n, largest);
		}
	}

	static void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heap(arr, n, i);

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			heap(arr, i, 0);
		}
	}

	public static void main(String[] args) {
		int[] salaries = { 55000, 72000, 48000, 91000, 66000 };
		heapSort(salaries);
		System.out.println("Sorted Applicants' Salaries: ");
		for (int s : salaries) {
			System.out.print(s + " ");
		}
	}
}