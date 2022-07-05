package Executor;

//import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduledExecutorServicePeriod {

    public static void main(String[] args) throws InterruptedException {

        java.util.concurrent.ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Tarea antes de ejecucion programada main....");

        //CountDownLatch low = new CountDownLatch(5);
        AtomicInteger atomic = new AtomicInteger(5); 
        Future<?> future = executor.scheduleAtFixedRate(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                
                //low.countDown();

                //decrementamos el numero atomico definido en este caso 5
                atomic.getAndDecrement();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("hello word schedule");
        }, 1000, 2000, TimeUnit.MICROSECONDS);

        //low.await();
        //future.cancel(true);
        // TimeUnit.SECONDS.sleep(10);

        //Validamos que el numero atomico definido sea mayor que sero
        while(atomic.get() >= 0){
            //Al validar que es igual a 0 detenemos el Thread future
            if(atomic.get() == 0){
                //Cancelamos el Thread
                future.cancel(true);
                //Hacemos que el contador sea negativo para que no entre al while
                //y asi siga la ejecucion del hilo principal
                atomic.getAndDecrement();
            }
        }
        System.out.println("Ejecutando tarea 2 en el main....");

        executor.shutdown();
    }
}
