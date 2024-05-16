// Write a program using Java CompletableFuture to parallelly execute tasks

// Simple Java program that demonstrates parallel execution of tasks using the CompletableFuture class, which is part of the java.util.concurrent package 

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ParallelTaskExecution {
    public static void main(String[] args) {
        // Define tasks to be executed in parallel
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate some computation
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 1 completed";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate some computation
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 2 completed";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate some computation
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task 3 completed";
        });

        // Combine tasks and get the results
        try {
            String result1 = task1.get();
            String result2 = task2.get();
            String result3 = task3.get();

            // Print results
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

// In this program:

// We define three tasks (task1, task2, and task3) using CompletableFuture.supplyAsync() method. Each task simulates some computation by sleeping for a certain amount of time.
// The supplyAsync() method starts a new asynchronous task and returns a CompletableFuture representing the result of the computation.
// We then combine these tasks using the get() method, which waits for the completion of each task and retrieves its result. Since get() is a blocking call, it waits until the task completes before moving on to the next task.
// Finally, we print the results of each task.