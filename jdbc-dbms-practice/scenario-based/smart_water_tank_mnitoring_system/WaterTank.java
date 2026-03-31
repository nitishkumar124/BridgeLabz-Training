package week9.smart_water_tank_mnitoring_system;
class WaterTank {
    private String tankId;
    private double capacity;
    private double currentLevel;

    public WaterTank(String tankId, double capacity, double currentLevel) {
        if (currentLevel > capacity) {
            throw new InvalidWaterLevelException("Water level exceeds capacity for tank: " + tankId);
        }
        this.tankId = tankId;
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }

    public double usagePercentage() {
        return (currentLevel / capacity) * 100;
    }

    public boolean isBelowThreshold() {
        return usagePercentage() < 20;
    }

    public double getCurrentLevel() {
        return currentLevel;
    }

    public String getTankId() {
        return tankId;
    }

    @Override
    public String toString() {
        return tankId + " | Level: " + currentLevel + "/" + capacity +
               " (" + String.format("%.2f", usagePercentage()) + "%)";
    }
}
