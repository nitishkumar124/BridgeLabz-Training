package week2.event_manager;
class TicketSorter {

    public void quickSort(Ticket[] tickets, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(tickets, low, high);

            // Recursively sort elements before and after partition
            quickSort(tickets, low, pi - 1);
            quickSort(tickets, pi + 1, high);
        }
    }

    private int partition(Ticket[] tickets, int low, int high) {
        // Choosing the last element as the pivot
        double pivot = tickets[high].price;
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            // If current ticket is cheaper than the pivot
            if (tickets[j].price < pivot) {
                i++;
                // Swap tickets[i] and tickets[j]
                Ticket temp = tickets[i];
                tickets[i] = tickets[j];
                tickets[j] = temp;
            }
        }

        // Swap the pivot ticket to its correct position
        Ticket temp = tickets[i + 1];
        tickets[i + 1] = tickets[high];
        tickets[high] = temp;

        return i + 1;
    }
}