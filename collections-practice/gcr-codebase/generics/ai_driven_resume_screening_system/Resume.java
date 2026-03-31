package generics.ai_driven_resume_screening_system;

class Resume<T extends JobRole> {
	private String candidateName;
	private double score;
	private T targetRole;

	public Resume(String candidateName, T targetRole, double score) {
		this.candidateName = candidateName;
		this.targetRole = targetRole;
		this.score = score;
	}

	public T getTargetRole() {
		return targetRole;
	}

	public double getScore() {
		return score;
	}

	public void displayResult() {
		System.out.println("Candidate: " + candidateName);
		System.out.println("Role: " + targetRole);
		System.out.println("AI Match Score: " + score + "%");
		System.out.println("Role Requirement: " + targetRole.getRequiredSkill());
	}
}