public class RunnableAndSynchronizedThread implements Runnable {

    private static int count = 0;

    // synchronized debe llevar un objeto
    // puede ser cualquier tipo de objeto y debe ser estatico
    private static Object object = new Object();

    @Override
    public void run() {

        // con synchronized se elimina la indeterminacion generada,
        // porque los hilos acceden a la misma variable N cantidad de veces al mismo
        // tiempo
        // con este metodo, se maneja como una region critca controlada
        // para asi determinar que cad hilo acceda a la variable cada uno a su tiempo
        synchronized (object) {
            for (int i = 0; i < 20000; i++) {
                count++;
            }

        }
    }

    public static void main(String[] args) {
        // Obteniendo los nucleos del CPU
        Runtime runtime = Runtime.getRuntime();

        // Cantidad de nucleos del CPU
        int core = runtime.availableProcessors();

        Thread[] hilos = new Thread[core];

        for (int i = 0; i < hilos.length; i++) {
            Runnable run = new RunnableAndSynchronizedThread();
            hilos[i] = new Thread(run);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length; i++) {
            try {
                hilos[i].join();
            } catch (Exception e) {
            }
        }

        System.out.println(count);
    }

}
