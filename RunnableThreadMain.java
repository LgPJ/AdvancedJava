public class RunnableThreadMain {
    
    public static void main(String[] args) {

        //se cread un objeto de tipo hilo, se le pasa la instancia de la clase que implementa Runnable
        new Thread(new RunnableThread("Pascua")).start();
        new Thread(new RunnableThread("Italia")).start();
        new Thread(new RunnableThread("Alemania")).start();
    }
}
