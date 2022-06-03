import java.util.concurrent.ThreadLocalRandom;

import Synchronization.Product;

public class LambdaProducerAndConsumer {

    public static void main(String[] args) {

        Product p = new Product();
        
        new Thread(() -> {

            for(int i = 0; i < 10; i++){

                p.manufacture("bread n: " + i);
                
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
            }
        } ).start();
        new Thread(() -> {

            for(int i = 0; i < 10; i++){
                p.receive();
            }

        } ).start();
    }
    
}
