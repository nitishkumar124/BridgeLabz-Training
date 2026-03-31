package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {

        String filePath =
            "employees.dat";

        // serialization
        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(101, "Amit", "IT", 50000));
        empList.add(new Employee(102, "Neha", "HR", 45000));
        empList.add(new Employee(103, "Rahul", "Finance", 55000));

        try {
            ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(filePath));

            oos.writeObject(empList);
            oos.close();

            System.out.println("Employees serialized successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // deserialization
        try {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(filePath));
            
            @SuppressWarnings("unchecked")
            List<Employee> savedList =
                (List<Employee>) ois.readObject();

            ois.close();

            System.out.println("\nDeserialized Employee Data:");
            for (Employee emp : savedList) {
                emp.display();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}