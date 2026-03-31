package week4_collections.restaurant_table_reservation;

public class Main {
    public static void main(String[] args) {

        RestaurantReservationSystem system = new RestaurantReservationSystem();

        system.addTable(new Table(1, 4));
        system.addTable(new Table(2, 6));
        system.addTable(new Table(3, 2));

        try {  
            system.reserveTable(1, "7PM-9PM", "Amit");
            system.reserveTable(2, "7PM-9PM", "Neha");
            system.reserveTable(1, "7PM-9PM", "Rahul"); 
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7PM-9PM");
        system.cancelReservation(1, "7PM-9PM");
        system.showAvailableTables("7PM-9PM");
    }
}

