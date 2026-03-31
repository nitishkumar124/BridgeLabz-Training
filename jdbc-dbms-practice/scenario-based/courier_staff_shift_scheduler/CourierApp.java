package week9.courier_staff_shift_scheduler;

public class CourierApp {
	public static void main(String[] args) {
		ShiftScheduler scheduler = new ShiftScheduler();

		Employee e1 = new Employee(1, "Rahul");
		Employee e2 = new Employee(2, "Aman");

		scheduler.addEmployee(e1);
		scheduler.addEmployee(e2);

		try {
			scheduler.assignShift(ShiftTime.MORNING, e1);
			scheduler.assignShift(ShiftTime.NIGHT, e2);
			scheduler.assignShift(ShiftTime.AFTERNOON, e1); // Exception
		} catch (ShiftAlreadyAssignedException e) {
			System.out.println(e.getMessage());
		}

		scheduler.printSchedule();
	}
}
