package services;

import myAnnotation.LogExecutionTime;

public class MyServiceImpl implements MyService{
    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(2000); // Simulating a slow process
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
