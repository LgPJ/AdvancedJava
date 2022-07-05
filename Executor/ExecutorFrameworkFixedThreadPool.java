package Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFrameworkFixedThreadPool {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        // Ejecuto un pool de hilos, dependiendo la cantidad definida
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Se envia el pool de Thread que se deben ejecutar
        // ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        Callable<String> task = () -> {
            System.out.println("RUN TASK.....");

            try {
                System.out.println("Name:" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("FIN TASK.....");
            return "DATA....";
        };

        Callable<Integer> taskTwo = () -> {
            System.out.println("Task 2");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> result = executor.submit(task);
        Future<String> resultTwo = executor.submit(task);
        Future<Integer> resultTree = executor.submit(taskTwo);

        // Espera que las tareas en cola, se ejecuten para finalizar el executor
        executor.shutdown();

        // mata el proceso del executor,
        // executor.shutdownNow();

        System.out.println("Ejecucion del MAIN... 1");

        System.out.println("Result future: " + result.isDone());

        while ((result.isDone() && resultTwo.isDone() && resultTree.isDone())) {
            System.out.println(String.format("Result one: %s - result two %s - result tree %s",
                    result.isDone() ? "Final" : "en proceso",
                    resultTwo.isDone() ? "Final" : "en proceso",
                    resultTree.isDone() ? "Final" : "en proceso"));

            TimeUnit.MILLISECONDS.sleep(1000);

        }

        System.out.println(result.get());
        System.out.println("Result future: " + result.isDone());
    }

}
