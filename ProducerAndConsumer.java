import Runnable.Consumer;
import Runnable.Producer;
import Synchronization.Product;

public class ProducerAndConsumer {

    public static void main(String[] args) {

        Product p = new Product();
        new Thread(new Producer(p)).start();
        new Thread(new Consumer(p)).start();
    }
    
}
