import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskThread  {

    public static void main(String[] args) {
        
        Timer timer = new Timer();

        //La tarea debe iniciar 5000 milsegundos despues del run, se debe reiniciar cada 10000 milisegundos
        //asi configuramos un tarea periodica
        timer.schedule(new TimerTask(){
              //La variable es opcional ya que no hemos definido el metodo para ser detenido
            int cont = 3;

            //TimerTask implementa de Ruunable por defecto
            @Override
            public void run() {
                if(cont > 0){
               System.out.println("Task period: " + new Date() + " Thread name: " 
               + Thread.currentThread().getName());
               cont--;
            } else {
                System.out.println("FIN");
                //Finalizacion del timer, para que no se ejecute de forma indefinida
                timer.cancel(); 
                }
            }
            //5000 Milisegundos que debe cumplir para su ejecucion
        }, 5000, 10000);
            //10000 milisegundos, indica cada cuanto tiempo se debe reiniciar la tarea

        System.out.println("Task para 5 seg mas.....");
    }
    
}
