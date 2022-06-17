package Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFramework {

    public static void main(String[] args) throws InterruptedException {
        
        //Ejecuto un unico Thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //Se envia el pool de Thread que se deben ejecutar
        //ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        
        Runnable task = () -> {
            System.out.println("RUN TASK.....");
            
            try {
                System.out.println("Name:" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("FIN TASK.....");
        };

        executor.submit(task);

        //Espera que las tareas en cola, se ejecuten para finalizar el executor
        executor.shutdown();

        //mata el proceso del executor,
        //executor.shutdownNow();

        System.out.println("Ejecucion del MAIN... 1");
        //Espera la finalizacion de todas las tareas, para asi continuar con el hilo principalç
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Ejecucion del MAIN...2");
    }
    
}
