package csv_data_handling;

import java.io.*;

public class JSONCSVConverter {

    public static void main(String[] args) throws Exception {

        jsonToCsv("students.json", "students.csv");
        csvToJson("students.csv", "students_back.json");
    }

    public static void jsonToCsv(String jsonFile, String csvFile) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(jsonFile));
        FileWriter writer = new FileWriter(csvFile);

        StringBuilder json = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        br.close();

        String data = json.toString()
                .replace("[", "")
                .replace("]", "");

        String[] records = data.split("\\},\\{");

        writer.write("ID,Name,Age,Marks\n");

        for (String record : records) {
            record = record.replace("{", "").replace("}", "");
            String[] fields = record.split(",");

            String id = fields[0].split(":")[1];
            String name = fields[1].split(":")[1].replace("\"", "");
            String age = fields[2].split(":")[1];
            String marks = fields[3].split(":")[1];

            writer.write(id + "," + name + "," + age + "," + marks + "\n");
        }

        writer.close();
        System.out.println("JSON → CSV done");
    }

    public static void csvToJson(String csvFile, String jsonFile) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        FileWriter writer = new FileWriter(jsonFile);

        br.readLine(); 
        writer.write("[\n");

        String line;
        boolean first = true;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (!first) writer.write(",\n");

            writer.write("  {\"id\":" + data[0] +
                    ",\"name\":\"" + data[1] +
                    "\",\"age\":" + data[2] +
                    ",\"marks\":" + data[3] + "}");

            first = false;
        }

        writer.write("\n]");
        br.close();
        writer.close();

        System.out.println("CSV → JSON done");
    }
}
