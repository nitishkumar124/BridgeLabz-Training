package week4_collections.restaurant_table_reservation;
import java.util.*;

public class RestaurantReservationSystem {

    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    public void reserveTable(int tableNumber, String timeSlot, String customerName)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved at " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, timeSlot, customerName));
        System.out.println("Table " + tableNumber + " reserved for " + customerName);
    }

    public void cancelReservation(int tableNumber, String timeSlot) {
        reservations.removeIf(r ->
                r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equals(timeSlot));
        System.out.println("Reservation cancelled");
    }

    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables at " + timeSlot + ":");

        for (Integer tableNo : tables.keySet()) {
            boolean isReserved = false;

            for (Reservation r : reservations) {
                if (r.getTableNumber() == tableNo &&
                    r.getTimeSlot().equals(timeSlot)) {
                    isReserved = true;
                    break;
                }
            }

            if (!isReserved) {
                System.out.println("Table " + tableNo);
            }
        }
    }
}

