package json_data;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

class Record {
    public int id;
    public String name;

    Record(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class JsonReport {

    public static void main(String[] args) throws Exception {

        List<Record> records = Arrays.asList(
                new Record(1, "User1"),
                new Record(2, "User2")
        );

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(records);

        System.out.println(json);
    }
}
