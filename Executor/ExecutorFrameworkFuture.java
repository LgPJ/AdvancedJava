package Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorFrameworkFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        
        //Ejecuto un unico Thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //Se envia el pool de Thread que se deben ejecutar
        //ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        
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

        Future<String> result = executor.submit(task);

        //Espera que las tareas en cola, se ejecuten para finalizar el executor
        executor.shutdown();

        //mata el proceso del executor,
        //executor.shutdownNow();

        System.out.println("Ejecucion del MAIN... 1");
        
        System.out.println("Result future: " + result.isDone());
        while(result.isDone()){
          System.out.println("Ejecutando tarea");
          
          TimeUnit.MILLISECONDS.sleep(1500);

        }

        System.out.println(result.get());
        System.out.println("Result future: " + result.isDone());
    }
    
}
