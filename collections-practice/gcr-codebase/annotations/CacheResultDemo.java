package annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class MathService {

    @CacheResult
    public int factorial(int n) {

        System.out.println("Computing factorial for: " + n);

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

class CacheManager {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeCachedMethod(
            Object obj,
            Method method,
            Object... args
    ) throws Exception {

        String key = method.getName() + "_" + args[0];

        if (cache.containsKey(key)) {
            System.out.println("Returning cached result for: " + key);
            return cache.get(key);
        }

        Object result = method.invoke(obj, args);
        cache.put(key, result);

        return result;
    }
}

public class CacheResultDemo {

    public static void main(String[] args) throws Exception {

        MathService service = new MathService();
        Method method = MathService.class.getMethod("factorial", int.class);

        int result1 = (int) CacheManager.invokeCachedMethod(service, method, 5);
        System.out.println("Result: " + result1);

        int result2 = (int) CacheManager.invokeCachedMethod(service, method, 5);
        System.out.println("Result: " + result2);

        int result3 = (int) CacheManager.invokeCachedMethod(service, method, 6);
        System.out.println("Result: " + result3);
    }
}
