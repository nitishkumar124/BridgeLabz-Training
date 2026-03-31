package week9.job_portal_resume_shortlisting_system;
import java.util.*;
class ResumeShortlistingSystem {

    public static List<Resume> shortlistResumes(List<Resume> resumes, Set<String> requiredSkills) {
        resumes.sort((r1, r2) -> 
            Integer.compare(
                r2.countMatchingSkills(requiredSkills),
                r1.countMatchingSkills(requiredSkills)
            )
        );
        return resumes;
    }
}
