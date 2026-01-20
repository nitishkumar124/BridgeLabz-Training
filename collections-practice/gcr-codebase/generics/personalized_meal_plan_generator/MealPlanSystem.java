package generics.personalized_meal_plan_generator;
public class MealPlanSystem {
    public static void main(String[] args) {
       
        Meal<VeganMeal> aliceMeal = MealGenerator.generatePlan("Alice", new VeganMeal());
        aliceMeal.printSummary();

        System.out.println("-----------------------------------");

		Meal<KetoMeal> bobMeal = MealGenerator.generatePlan("Bob", new KetoMeal());
		bobMeal.printSummary();
 
    }
}