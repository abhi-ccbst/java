import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class Main {
//    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newScheduledThreadPool(3);
//        List<Future<String>> futures = new ArrayList<>();
//        futures.add(executorService.submit(new WeatherFetcher("API-1", 5)));
//        futures.add(executorService.submit(new WeatherFetcher("API-2", 5)));
//        futures.add(executorService.submit(new WeatherFetcher("API-3", 2)));
//
//
//        futures.add(executorService.submit(new WeatherFetcher("API-4", 1)));
//        futures.add(executorService.submit(new WeatherFetcher("API-5", 2)));
//        futures.add(executorService.submit(new WeatherFetcher("API-6", 1)));
//
//
//        while (!futures.isEmpty()) {
//            Iterator<Future<String>> iterator = futures.iterator();
//            while (iterator.hasNext()) {
//                Future<String> future = iterator.next();
//                if(future.isDone() ) {
//                    try {
//                        System.out.println(future.get()); // Get result
//                    } catch (InterruptedException | ExecutionException e) {
//                        System.out.println(e.getMessage());
//                    }
//                    iterator.remove();
//                }
//                try {
//                    Thread.sleep(500);
//                    System.out.println("Waiting...");
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            }
//        }
//        executorService.shutdown();
//    }

    public static void main(String[] args) {
        int numberOfWorker = 3;
        CountDownLatch latch = new CountDownLatch(numberOfWorker);
        for (int i = 1; i <= numberOfWorker; i++ ) {
            new Worker(latch, i).start();
        }
        try  {
            System.out.println("Main thread waiting for workers to finish...");
            latch.await();
            System.out.println("All workers are done. Main thread resumes.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}