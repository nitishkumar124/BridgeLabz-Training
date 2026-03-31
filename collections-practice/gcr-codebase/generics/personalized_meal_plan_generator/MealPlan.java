package generics.personalized_meal_plan_generator;

interface MealPlan {
	String getPlanDetails();

	int getCalorieCount();
}

class VeganMeal implements MealPlan {
	public String getPlanDetails() {
		return "Plant-based proteins, legumes, and leafy greens.";
	}

	public int getCalorieCount() {
		return 1800;
	}
}

class KetoMeal implements MealPlan {
	public String getPlanDetails() {
		return "High fats, moderate proteins, and very low carbs.";
	}

	public int getCalorieCount() {
		return 2200;
	}
}

class HighProteinMeal implements MealPlan {
	public String getPlanDetails() {
		return "Lean meats, eggs, and whey protein focus.";
	}

	public int getCalorieCount() {
		return 2500;
	}
}