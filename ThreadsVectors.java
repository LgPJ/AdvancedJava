public class ThreadsVectors extends Thread {
    
    private int id;

    public ThreadsVectors(int id){
        this.id = id;
    }

    @Override
    public void run(){
        System.out.println("Thread: " + id);
    }

    public static void main(String[] args) {
        
        ThreadsVectors[] vec = new ThreadsVectors[5];

        for(int i = 0; i < vec.length; i++){
            vec[i] = new ThreadsVectors(i + 1);
            vec[i].start();
        }

        try {
            /*** El hilo principal se ejecuta despues de la ejecucion de los 2 hilos particulares
             *  vec[0].join();
             *  vec[3].join();
             */

            //El hilo principal se ejecuta despues de todos los demas hilos
            for(int i = 0; i < vec.length; i++){
                vec[i].join();
            }
        } catch (Exception e) {}

        System.out.println("Thread main.");
    }
    
}
