package generics.ai_driven_resume_screening_system;

import java.util.ArrayList;
import java.util.List;

class ScreeningProcessor {

	public static void processBatch(List<Resume<? extends JobRole>> batch) {
		System.out.println("\n--- Starting AI Screening Pipeline ---");
		for (Resume<? extends JobRole> resume : batch) {
			resume.displayResult();
			if (resume.getScore() >= 80) {
				System.out.println("Status: Shortlisted for Interview");
			} else {
				System.out.println("Status: Keep in Talent Pool");
			}
			System.out.println("------------------------------------");
		}
	}
}