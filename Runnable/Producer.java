package Runnable;

import java.util.concurrent.ThreadLocalRandom;

import Synchronization.Product;

public class Producer implements Runnable{

    private Product product;

    public Producer(Product product){
        this.product = product;
    }
    
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            product.manufacture("bread n: " + i);
            
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
}
