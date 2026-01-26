package streams;

import java.io.*;

public class StudentData {

    public static void main(String[] args) {

        String filePath =
            "student.dat";

        try (
            DataOutputStream dos =
                new DataOutputStream(new FileOutputStream(filePath))
        ) {
            dos.writeInt(101);           
            dos.writeUTF("Aryansh");       
            dos.writeDouble(8.75);          

            System.out.println("Data written successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
            DataInputStream dis =
                new DataInputStream(new FileInputStream(filePath))
        ) {
            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Retrieved Student Data:");
            System.out.println("Roll No: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

