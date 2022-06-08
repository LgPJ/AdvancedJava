package Timer;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerThread {

    public static void main(String[] args) {
        
        Timer timer = new Timer();

        //La tarea debe iniciar 5000 milsegundos despues del run
        timer.schedule(new TimerTask(){
            //TimerTask implementa de Ruunable por defecto
            @Override
            public void run() {

               System.out.println("Task: " + new Date() + " Thread name: " 
               + Thread.currentThread().getName());
               System.out.println("FIN");
               //Finalizacion del timer, para que no se ejecute de forma indefinida
               timer.cancel(); 
            }
            //Milisegundos que debe cumplir
        }, 5000);

        System.out.println("Task para 5 seg mas.....");
    }
    
}
