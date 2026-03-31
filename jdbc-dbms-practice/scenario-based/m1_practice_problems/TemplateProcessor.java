package m1_practice_problems;
import java.util.*;
import java.util.regex.*;

public class TemplateProcessor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String line = sc.nextLine();
            System.out.println(process(line));
        }
    }

    public static String process(String line) {

        Pattern pattern = Pattern.compile("\\$\\{(.*?):(.*?)\\}");
        Matcher matcher = pattern.matcher(line);

        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String type = matcher.group(1);
            String value = matcher.group(2);

            String replacement = handle(type, value);

            matcher.appendReplacement(result, replacement);
        }

        matcher.appendTail(result);
        return result.toString();
    }

    public static String handle(String type, String value) {
        try {
            switch (type) {

                case "UPPER":
                    return value.toUpperCase();

                case "LOWER":
                    return value.toLowerCase();

                case "DATE":
                    String[] d = value.split("-");
                    int day = Integer.parseInt(d[0]);
                    int month = Integer.parseInt(d[1]);
                    int year = Integer.parseInt(d[2]);

                    if (day < 1 || day > 31 || month < 1 || month > 12)
                        return "INVALID";

                    return year + "/" + String.format("%02d", month) + "/" + String.format("%02d", day);

                case "REPEAT":
                    String[] parts = value.split(",");
                    String word = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < count; i++) sb.append(word);
                    return sb.toString();
            }
        } catch (Exception e) {
            return "INVALID";
        }

        return "INVALID";
    }
}