package myAnnotation;

import java.lang.reflect.Method;

public class AnnotationProcessor {
    public static void invokeWithLogging(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    long start = System.currentTimeMillis();
                    method.invoke(obj);
                    long end = System.currentTimeMillis();
                    System.out.println("Execution time of " + method.getName() + ": " + (end - start) + " ms");
                } catch (Exception e) {
                   System.out.println(e.getMessage());
                }
            }
        }
    }
}

