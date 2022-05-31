import java.util.Random;

public class ConditionSaveWaitNotifyAll implements Runnable {

    private int id;
    private static Random key = new Random();
    private static int cont = 0;

    public ConditionSaveWaitNotifyAll(int id){
        this.id = id;
    }

    @Override
    public void run() {
        //synchronized genera una cola de hilos, para que asi se ejecuten de uno a uno
        synchronized(key){

            if(id != cont){

                try {
                    //Con wait, se genera un cola de hilos, ya no esperan para entrar al synchronized 
                    //sino que estan dormidos
                    key.wait();   
                } catch (Exception e) {}
            }

            System.out.println("Thread: " + id);
            cont++;
            //Despierta a todos los hilos que estan durmiendo en el wait
            key.notifyAll();
        } 
    }

    public static void main(String[] args) {
        Runtime run = Runtime.getRuntime();
        int core = run.availableProcessors();

        Thread[] hilos = new Thread[core];

        for(int i = 0; i < hilos.length; i++){
            Runnable runnable = new ConditionSaveWaitNotifyAll(i);
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        }

        for(int i = 0; i < hilos.length; i++){
            try {
                hilos[i].join();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
        System.out.println("Principal");
    }


    
}
