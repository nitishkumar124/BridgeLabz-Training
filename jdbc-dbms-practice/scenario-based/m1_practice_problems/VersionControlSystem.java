package m1_practice_problems;
import java.util.*;

public class VersionControlSystem {

    static Map<String, Map<String, Integer>> fileMap = new HashMap<>();

    static Map<String, List<String>> uploadOrder = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            String operation = parts[0];

            switch (operation) {

                case "UPLOAD":
                    upload(parts[1], parts[2], Integer.parseInt(parts[3]));
                    break;

                case "FETCH":
                    fetch(parts[1]);
                    break;

                case "LATEST":
                    latest(parts[1]);
                    break;

                case "TOTAL_STORAGE":
                    totalStorage(parts[1]);
                    break;
            }
        }
    }

    public static void upload(String fileName, String version, int size) {

        fileMap.putIfAbsent(fileName, new HashMap<>());
        uploadOrder.putIfAbsent(fileName, new ArrayList<>());

        Map<String, Integer> versions = fileMap.get(fileName);

        if (versions.containsKey(version)) return;

        versions.put(version, size);
        uploadOrder.get(fileName).add(version);
    }

    public static void fetch(String fileName) {

        if (!fileMap.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        Map<String, Integer> versions = fileMap.get(fileName);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(versions.entrySet());

        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(fileName + " " + entry.getKey() + " " + entry.getValue());
        }
    }

    public static void latest(String fileName) {

        if (!uploadOrder.containsKey(fileName) || uploadOrder.get(fileName).isEmpty()) {
            System.out.println("File Not Found");
            return;
        }

        List<String> list = uploadOrder.get(fileName);
        String lastVersion = list.get(list.size() - 1);

        int size = fileMap.get(fileName).get(lastVersion);

        System.out.println(fileName + " " + lastVersion + " " + size);
    }

    public static void totalStorage(String fileName) {

        if (!fileMap.containsKey(fileName)) {
            System.out.println("File Not Found");
            return;
        }

        int sum = 0;
        for (int size : fileMap.get(fileName).values()) {
            sum += size;
        }

        System.out.println(fileName + " " + sum);
    }
}