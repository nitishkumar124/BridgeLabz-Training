package level3;
import java.util.*;
public class CalculateGrade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter physics marks : ");
		double phy = sc.nextDouble();
		System.out.print("Enter chemistry marks : ");
		double chem = sc.nextDouble();
		System.out.print("Enter maths marks : ");
		double maths = sc.nextDouble();
		double marksObtained = phy + chem + maths;
		double totalMarks = 300;
		double percent = marksObtained / totalMarks * 100;
		char grade;
		String remark;
		if (percent > 79) {
			grade = 'A';
			remark = "Level 4, above agency-normalized standards";
		}
		else if (percent > 69) {
			grade = 'B';
			remark = "Level 3, at agency-normalized standards";
		}
		else if (percent > 59) {
			grade = 'C';
			remark = "Level 2, below, but approaching agency-normalized standards";
		}
		else if (percent > 49) {
			grade = 'D';
			remark = "Level 1, well below agency-normalized standards";
		}
		else if (percent > 39) {
			grade = 'E';
			remark = "Level 1-, too below agency-normalized standards";
		}
		else {
			grade = 'R';
			remark = "Remedial standards";
		}
		
		System.out.println("Grade : " + grade);
		System.out.println("Remark : " + remark);

		sc.close();
	}
}

