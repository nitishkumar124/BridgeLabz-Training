package m1_practice_problems;
import java.util.*;

class Student {
    String name, dept;
    int q1, q2, q3;

    Student(String name, String dept, int q1, int q2, int q3) {
        this.name = name;
        this.dept = dept;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizRankingSystem {

    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");

            if (parts[0].equals("Record")) {
                String name = parts[1];
                String dept = parts[2];
                int q1 = Integer.parseInt(parts[3]);
                int q2 = Integer.parseInt(parts[4]);
                int q3 = Integer.parseInt(parts[5]);

                students.add(new Student(name, dept, q1, q2, q3));
                System.out.println("Record Added: " + name);
            }

            else if (parts[0].equals("Top")) {
                if (students.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                String arg = parts[1];

                if (arg.equals("Q1") || arg.equals("Q2") || arg.equals("Q3")) {
                    topQuiz(arg);
                } else {
                    topDepartment(arg);
                }
            }
        }
    }
    // Top Department
    public static void topDepartment(String dept) {
        List<Student> list = new ArrayList<>();

        for (Student s : students) {
            if (s.dept.equals(dept)) {
                list.add(s);
            }
        }

        if (list.isEmpty()) {
            System.out.println("Department Not Found");
            return;
        }

        int max = 0;
        for (Student s : list) {
            max = Math.max(max, s.total());
        }

        for (Student s : list) {
            if (s.total() == max) {
                System.out.println(s.name + " " + s.total());
            }
        }
    }

    public static void topQuiz(String quiz) {
        int max = 0;

        for (Student s : students) {
            if (quiz.equals("Q1")) max = Math.max(max, s.q1);
            else if (quiz.equals("Q2")) max = Math.max(max, s.q2);
            else max = Math.max(max, s.q3);
        }

        for (Student s : students) {
            if ((quiz.equals("Q1") && s.q1 == max) ||
                (quiz.equals("Q2") && s.q2 == max) ||
                (quiz.equals("Q3") && s.q3 == max)) {

                int score = quiz.equals("Q1") ? s.q1 :
                            quiz.equals("Q2") ? s.q2 : s.q3;

                System.out.println(s.name + " " + score);
            }
        }
    }
}