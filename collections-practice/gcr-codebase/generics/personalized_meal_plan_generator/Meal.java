package generics.personalized_meal_plan_generator;

class Meal<T extends MealPlan> {
	private String userName;
	private T plan;

	public Meal(String userName, T plan) {
		this.userName = userName;
		this.plan = plan;
	}

	public void printSummary() {
		System.out.println("User: " + userName);
		System.out.println("Diet Type: " + plan.getClass().getSimpleName());
		System.out.println("Details: " + plan.getPlanDetails());
		System.out.println("Target Calories: " + plan.getCalorieCount() + " kcal");
	}
}