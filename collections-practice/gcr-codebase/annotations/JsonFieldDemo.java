package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();   
}

class User1 {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User1(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

class JsonSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder();
        json.append("{");

        boolean first = true;

        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                Object value = field.get(obj);

                if (!first) {
                    json.append(", ");
                }

                json.append("\"")
                    .append(annotation.name())
                    .append("\": ");

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }
}

public class JsonFieldDemo {

    public static void main(String[] args) throws Exception {

        User1 user = new User1("Aryansh", 22, "aryansh@gmail.com");

        String jsonOutput = JsonSerializer.toJson(user);
        System.out.println(jsonOutput);
    }
}
