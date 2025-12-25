package level1;

public class DistributePenToStudents {

	public static void main(String[] args) {
		int pen = 10;
		int students = 3;
		
		int remainingPen = pen % students;
		int penRecieved = pen / students;
		
		System.out.println("The Pen Per Student is " + penRecieved + " and the remaining pen not distributed is " + remainingPen);

	}

}
