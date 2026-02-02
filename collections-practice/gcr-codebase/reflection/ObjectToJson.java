package reflection;
import java.lang.reflect.Field;

class Person1 {
    int age = 22;
    String name = "Aryansh";
}

public class ObjectToJson {

    public static String toJson(Object obj) throws Exception {

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder json = new StringBuilder("{");

        for (Field f : fields) {
            f.setAccessible(true);
            json.append("\"")
                .append(f.getName())
                .append("\":\"")
                .append(f.get(obj))
                .append("\",");
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Person1 p = new Person1();
        System.out.println(toJson(p));
    }
}
