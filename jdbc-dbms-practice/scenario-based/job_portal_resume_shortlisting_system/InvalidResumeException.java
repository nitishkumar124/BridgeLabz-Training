package week9.job_portal_resume_shortlisting_system;
import java.util.*;

class InvalidResumeException extends Exception {
    public InvalidResumeException(String message) {
        super(message);
    }
}

class Resume {
    private String candidateName;
    private Set<String> skills;

    public Resume(String candidateName, Set<String> skills) throws InvalidResumeException {
        if (candidateName == null || candidateName.isEmpty() || skills == null || skills.isEmpty()) {
            throw new InvalidResumeException("Invalid resume: name or skills missing");
        }
        this.candidateName = candidateName;
        this.skills = skills;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public int countMatchingSkills(Set<String> requiredSkills) {
        int count = 0;
        for (String skill : requiredSkills) {
            if (skills.contains(skill)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return candidateName + " - Skills: " + skills;
    }
}
