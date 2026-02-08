package user;

public class Faculty implements User {

    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public void showRole() {
        System.out.println(name + " is a Faculty member.");
    }
    
    @Override
    public void update(String message) {
        System.out.println("Notification to Faculty " + name + ": " + message);
    }

    @Override
    public String getName() {
        return name;
    }
}
