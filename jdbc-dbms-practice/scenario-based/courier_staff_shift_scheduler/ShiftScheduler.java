package week9.courier_staff_shift_scheduler;

import java.util.*;

class ShiftScheduler {
	private List<Employee> employees = new ArrayList<>();
	private Map<ShiftTime, List<Employee>> shiftMap = new HashMap<>();

	public void addEmployee(Employee emp) {
		employees.add(emp);
	}

	public void assignShift(ShiftTime shift, Employee emp) throws ShiftAlreadyAssignedException {
		shiftMap.putIfAbsent(shift, new ArrayList<>());

		for (List<Employee> list : shiftMap.values()) {
			if (list.contains(emp)) {
				throw new ShiftAlreadyAssignedException("Employee already assigned to another shift");
			}
		}

		shiftMap.get(shift).add(emp);
		System.out.println(emp + " assigned to " + shift);
	}

	public void printSchedule() {
		shiftMap.forEach((shift, list) -> {
			System.out.println(shift + " -> " + list);
		});
	}
}
