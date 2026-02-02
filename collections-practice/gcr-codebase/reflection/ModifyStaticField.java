package reflection;
import java.lang.reflect.Field;

class Configuration {

    private static String API_KEY = "OLD-KEY";

    public static void showKey() {
        System.out.println("API-KEY = " + API_KEY);
    }
}

public class ModifyStaticField {

    public static void main(String[] args) {

        try {
            Configuration.showKey();

            Class<?> cls = Configuration.class;
            Field field = cls.getDeclaredField("API_KEY");

            field.setAccessible(true);
            field.set(null, "NEW-SECRET-KEY");

            Configuration.showKey();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
