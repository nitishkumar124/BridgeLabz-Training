package week9.event_feedback_rating_analyzer;
import java.util.*;
class EventFeedbackSystem {

    private Map<String, List<Integer>> feedbackMap = new HashMap<>();

    public void addRating(String eventId, int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5");
        }

        feedbackMap.putIfAbsent(eventId, new ArrayList<>());
        feedbackMap.get(eventId).add(rating);
    }

    public double calculateAverageRating(String eventId) {
        List<Integer> ratings = feedbackMap.get(eventId);
        if (ratings == null || ratings.isEmpty()) return 0.0;

        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        return (double) sum / ratings.size();
    }

    public String getTopRatedEvent() {
        String topEvent = null;
        double maxAvg = 0.0;

        for (String eventId : feedbackMap.keySet()) {
            double avg = calculateAverageRating(eventId);
            if (avg > maxAvg) {
                maxAvg = avg;
                topEvent = eventId;
            }
        }
        return topEvent;
    }

    public void printReport() {
        for (String eventId : feedbackMap.keySet()) {
            System.out.println("Event: " + eventId + 
                ", Average Rating: " + calculateAverageRating(eventId));
        }
    }
}