package generics.ai_driven_resume_screening_system;
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public abstract String getRequiredSkill();

    @Override
    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() { super("Software Engineer"); }
    public String getRequiredSkill() { return "Java/Python & System Design"; }
}

class DataScientist extends JobRole {
    public DataScientist() { super("Data Scientist"); }
    public String getRequiredSkill() { return "Machine Learning & Statistics"; }
}

class ProductManager extends JobRole {
    public ProductManager() { super("Product Manager"); }
    public String getRequiredSkill() { return "Product Roadmap & Agile"; }
}