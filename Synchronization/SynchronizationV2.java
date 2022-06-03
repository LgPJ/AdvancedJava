package Synchronization;

public class SynchronizationV2 {
    
    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintPhrase("Holaa", "Que tal?")).start();
        new Thread(new PrintPhrase("Quien eres?", "tu")).start();
       
        //Al iniciar se ejecutan los 2 primeros hilos y al ingresar al tercero, espera y se encuentra en estado bloqueado
        Thread.sleep(100);

        Thread thread3 = new Thread(new PrintPhrase("Muchas", "gracias, amigo"));

        //Inicio del 3er hilo
        thread3.start();

        //Duermen el hilo general antes de que el hilo 3 ingrese al metodo de imprimir
        Thread.sleep(500);

        System.out.println(thread3.getState()); //Sin el segundo sleep su estado es runnable
        //con el segundo sleep el estado en bloqueado
    }

    //Sincronizamos el metodo para que los hilos accedan en orden
    public synchronized static void printPhrase(String phrase1, String phrase2){
       
        System.out.print(phrase1 + " ");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(phrase2);
    }
}
