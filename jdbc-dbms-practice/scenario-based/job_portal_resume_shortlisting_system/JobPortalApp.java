package week9.job_portal_resume_shortlisting_system;
import java.util.*;
public class JobPortalApp {
    public static void main(String[] args) throws Exception {

        Set<String> jobSkills = new HashSet<>(Arrays.asList("Java", "Spring", "SQL"));

        List<Resume> resumes = new ArrayList<>();

        resumes.add(new Resume("Amit", new HashSet<>(Arrays.asList("Java", "Spring"))));
        resumes.add(new Resume("Neha", new HashSet<>(Arrays.asList("Java", "SQL", "Spring"))));
        resumes.add(new Resume("Ravi", new HashSet<>(Arrays.asList("Python", "Django"))));

        List<Resume> ranked = ResumeShortlistingSystem.shortlistResumes(resumes, jobSkills);

        System.out.println("Ranked Resumes:");
        for (Resume r : ranked) {
            System.out.println(r.getCandidateName() + 
                " -> Match Count: " + r.countMatchingSkills(jobSkills));
        }
    }
}
