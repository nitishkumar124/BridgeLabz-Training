package reflection;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Student {
    int id;
    String name;
}

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> props)
            throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : props.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Map<String, Object> map = new HashMap<>();
        map.put("id", 101);
        map.put("name", "Aryansh");

        Student s = toObject(Student.class, map);
        System.out.println(s.id + " " + s.name);
    }
}
