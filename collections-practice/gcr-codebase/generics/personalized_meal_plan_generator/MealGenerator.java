package generics.personalized_meal_plan_generator;

class MealGenerator {

	public static <T extends MealPlan> Meal<T> generatePlan(String name, T planType) {
		System.out.println("...Generating personalized plan for " + name + "...");

		if (planType == null) {
			throw new IllegalArgumentException("Meal plan type cannot be null");
		}

		return new Meal<>(name, planType);
	}
}