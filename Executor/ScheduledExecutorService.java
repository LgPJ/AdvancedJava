package Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {
    
    public static void main(String[] args) {
        
        java.util.concurrent.ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Tarea antes de ejecucion programada main....");
    
        executor.schedule(()-> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("hello word schedule");
        }, 0, TimeUnit.MICROSECONDS);


        System.out.println("Ejecutando tarea 2 en el main....");
        executor.shutdown();
    }
}
