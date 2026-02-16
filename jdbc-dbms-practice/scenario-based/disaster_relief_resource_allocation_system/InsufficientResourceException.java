package week9.disaster_relief_resource_allocation_system;
class InsufficientResourceException extends RuntimeException {
    public InsufficientResourceException(String message) {
        super(message);
    }
}
