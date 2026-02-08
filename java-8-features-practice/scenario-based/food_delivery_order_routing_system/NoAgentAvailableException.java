package week6_java8.food_delivery_order_routing_system;
class NoAgentAvailableException extends Exception {
    public NoAgentAvailableException(String message) {
        super(message);
    }
}