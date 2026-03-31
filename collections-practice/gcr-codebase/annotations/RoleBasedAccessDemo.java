package annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();   
}

class SecurityContext {

    private static String currentUserRole;

    public static void setRole(String role) {
        currentUserRole = role;
    }

    public static String getRole() {
        return currentUserRole;
    }
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully");
    }

    @RoleAllowed("ADMIN")
    public void viewAllUsers() {
        System.out.println("Displaying all user");
    }

    public void publicInfo() {
        System.out.println("This is public information.");
    }
}

public class RoleBasedAccessDemo {

    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Class<?> clazz = service.getClass();

        System.out.println("Current Role: USER");
        SecurityContext.setRole("USER");
        invokeMethods(service, clazz);

        System.out.println("\nCurrent Role: ADMIN");
        SecurityContext.setRole("ADMIN");
        invokeMethods(service, clazz);
    }

    private static void invokeMethods(Object obj, Class<?> clazz) throws Exception {

        for (Method method : clazz.getDeclaredMethods()) {

            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (SecurityContext.getRole().equals(roleAllowed.value())) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! → " + method.getName());
                }

            } else {
                method.invoke(obj); 
            }
        }
    }
}

