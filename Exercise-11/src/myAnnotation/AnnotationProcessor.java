package myAnnotation;

import java.lang.reflect.Method;


// Limitation: 1. Can only handle the method with 0 parameter
//             2. All method will be invoked by default
public class AnnotationProcessor {
    public static void invokeWithLogging(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long start = System.currentTimeMillis();
                    method.invoke(obj);   // Reason why all method get invoked directly.
                    long end = System.currentTimeMillis();
                    System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " ms  Thread name: " + Thread.currentThread().getName());
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                }
            }
        }
    }
}

