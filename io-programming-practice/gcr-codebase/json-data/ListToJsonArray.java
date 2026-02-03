package json_data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class User {
    public String name;
    public int age;

    User(String n, int a) {
        name = n;
        age = a;
    }
}

public class ListToJsonArray {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<User> users = Arrays.asList(
                new User("A", 20),
                new User("B", 30)
        );

        String json = mapper.writeValueAsString(users);
        System.out.println(json);
    }
}
