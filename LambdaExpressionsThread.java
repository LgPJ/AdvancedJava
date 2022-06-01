public class LambdaExpressionsThread {

    public static void main(String[] args) {

        // Definicion anonima del metodo Runnable para creacion de Thread
        /*Runnable run = new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    //Se accede a la interface Thread a currentThread el cual retorna la instancia del hilo actual
                    // y con getName se obtiene el nombre del hilo en cuestion
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Me voy de viaje a: " + Thread.currentThread().getName());
            }

        };*/

        /**Definicion del Thread con runnable y expresiones lambda */
        Runnable run = () -> {
            for (int i = 0; i < 10; i++) {

                //Se accede a la interface Thread a currentThread el cual retorna la instancia del hilo actual
                // y con getName se obtiene el nombre del hilo en cuestion
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Me voy de viaje a: " + Thread.currentThread().getName());
        };
        //Definicion y aranque de los hilos
        /**run = instancia del Thread
         * "String" = nombre del Hilo
         */
        new Thread(run, "Pascua").start();
        new Thread(run, "Maldiva").start();
        new Thread(run, "Australia").start();
        new Thread(run, "MVP").start();
    }

}
