package week2.event_manager;
class Ticket {
    String eventName;
    double price;

    public Ticket(String eventName, double price) {
        this.eventName = eventName;
        this.price = price;
    }

    @Override
    public String toString() {
        return eventName + ": $" + price;
    }
}

