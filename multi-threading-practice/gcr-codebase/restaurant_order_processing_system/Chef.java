package multi_threading.restaurant_order_processing_system;

class Chef extends Thread {

    private String dishName;
    private int cookingTime;

    public Chef(String chefName, String dishName, int cookingTime) {
        super(chefName);
        this.dishName = dishName;
        this.cookingTime = cookingTime;
    }

    @Override
    public void run() {

        System.out.println(getName() + " started preparing " + dishName);

        int stepTime = cookingTime / 4;

        try {
            Thread.sleep(stepTime);
            System.out.println(getName() + " preparing " + dishName + ": 25% complete");

            Thread.sleep(stepTime);
            System.out.println(getName() + " preparing " + dishName + ": 50% complete");

            Thread.sleep(stepTime);
            System.out.println(getName() + " preparing " + dishName + ": 75% complete");

            Thread.sleep(stepTime);
            System.out.println(getName() + " preparing " + dishName + ": 100% complete");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(getName() + " finished preparing " + dishName);
    }
}
