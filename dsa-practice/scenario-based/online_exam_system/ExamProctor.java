package week3.online_exam_system;
import java.util.*;

public class ExamProctor {
    private Stack<Integer> navigationStack;      
    private Map<Integer, String> studentAnswers; 
    private Map<Integer, Question> questionBank; 

    public ExamProctor() {
        this.navigationStack = new Stack<>();
        this.studentAnswers = new HashMap<>();
        this.questionBank = new HashMap<>();
    }

    public void addQuestionToBank(Question q) {
        questionBank.put(q.id, q);
    }


    public void answerQuestion(int questionId, String answer) {
        if (!questionBank.containsKey(questionId)) {
            System.out.println("Invalid Question ID.");
            return;
        }
        

        navigationStack.push(questionId);

        studentAnswers.put(questionId, answer);
        
        System.out.println("Recorded answer for Question " + questionId);
    }

    public void goBack() {
        if (navigationStack.size() > 1) {
			navigationStack.pop();
			int previousId = navigationStack.peek();
			System.out.println("Returning to previous Question: " + previousId);
		} else {
			System.out.println("Already at the first question visited.");
		}
	}

    public int calculateScore() {
        int score = 0;
        for (Integer qId : studentAnswers.keySet()) {
            String studentAns = studentAnswers.get(qId);
            String correctAns = questionBank.get(qId).correctAnswer;

            if (studentAns.equalsIgnoreCase(correctAns)) {
                score++;
            }
        }
        return score;
    }

    public void submitExam() {
        int finalScore = calculateScore();
        System.out.println("\n--- Exam Submitted ---");
        System.out.println("Total Questions Answered: " + studentAnswers.size());
        System.out.println("Final Score: " + finalScore + "/" + questionBank.size());
        System.out.println("----------------------\n");
    }
}