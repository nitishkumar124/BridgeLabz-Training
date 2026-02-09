package week9.event_feedback_rating_analyzer;
public class EventFeedbackApp {
    public static void main(String[] args) throws Exception {

        EventFeedbackSystem system = new EventFeedbackSystem();

        system.addRating("EVT101", 5);
        system.addRating("EVT101", 4);
        system.addRating("EVT102", 3);
        system.addRating("EVT102", 4);
        system.addRating("EVT103", 5);
        system.addRating("EVT103", 5);

        system.printReport();

        System.out.println("Top Rated Event: " + system.getTopRatedEvent());
    }
}
