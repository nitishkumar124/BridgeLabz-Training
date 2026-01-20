package generics.ai_driven_resume_screening_system;

import java.util.*;

public class ResumeScreeningSystem {
	public static void main(String[] args) {

		Resume<SoftwareEngineer> devResume = new Resume<>("Alice", new SoftwareEngineer(), 88.5);
		Resume<DataScientist> dsResume = new Resume<>("Bob", new DataScientist(), 75.0);
		Resume<ProductManager> pmResume = new Resume<>("Charlie", new ProductManager(), 92.0);

		List<Resume<? extends JobRole>> pipeline = new ArrayList<>();
		pipeline.add(devResume);
		pipeline.add(dsResume);
		pipeline.add(pmResume);

		ScreeningProcessor.processBatch(pipeline);
	}
}