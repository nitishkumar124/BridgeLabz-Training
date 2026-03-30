package sorting_algorithm;

public class StudentAges {
    public static void main(String[] args) {

        int[] ages = {21, 19, 22, 20, 23};

        int minAge = ages[0];
        int maxAge = ages[0];

        for (int age : ages) {
            if (age < minAge) minAge = age;
            if (age > maxAge) maxAge = age;
        }

        int[] count = new int[maxAge + 1];

        for (int age : ages) {
            count[age]++;
        }

        System.out.print("Sorted Ages: ");
        for (int i = minAge; i <= maxAge; i++) {
            while (count[i] > 0) {
                System.out.print(i + " ");
                count[i]--;
            }
        }
    }
}