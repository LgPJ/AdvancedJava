package Synchronization;

public class Product {

    private String bread;
    private boolean available;

    public synchronized void manufacture(String dough) {

        //Cuando esta available = true el metodo espera con el wait
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bread = dough;
        System.out.println("bread producer: " + this.bread);
        //System.out.println("customer consumes bread: " + this.bread);
        this.available = true;
        //se genera una notificacion para que el consumir pueda recibir lo que el productor genero
        notify();
    }

    public synchronized String receive(){
        while(!available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("customer consumes bread: " + this.bread);
        this.available = false;
        notify();
        return bread;
    }

}
