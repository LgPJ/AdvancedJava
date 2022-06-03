package Thread;
public class InheritanceThreadMain {

    public static void main(String[] args){

        // Declaración de 2 threads
        InheritanceThread t1 =new InheritanceThread("PING",33);
        InheritanceThread t2= new InheritanceThread("PONG",10);

        // Activación
        t1.start();
        t2.start();

        // Espera 2 segundos
        try{ 
            Thread.sleep(5000);

        }catch (InterruptedException e){};

            t1.interrupt();
            t2.interrupt();
        }

        
}

