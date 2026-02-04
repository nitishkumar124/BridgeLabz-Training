package functional_interfaces;

public class Export{

    interface Exporter {
        void exportCSV();
        void exportPDF();

        default void exportJSON() {
            System.out.println("Exported JSON");
        }
    }

    static class Report implements Exporter {
        public void exportCSV() { System.out.println("CSV"); }
        public void exportPDF() { System.out.println("PDF"); }
    }

    public static void main(String[] args) {
        Exporter e = new Report();
        e.exportJSON();
    }
}

