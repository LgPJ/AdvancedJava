public class IndeterminismThread extends Thread{

    private static int count = 0;

    @Override
    public void run(){
        for(int i = 0; i < 100; i++){
            count++;
        }
    }

    public static void main(String[] args) {
        
        IndeterminismThread[] vec = new IndeterminismThread[100];

        for(int i = 0; i < vec.length; i++){
            vec[i] = new IndeterminismThread();
            vec[i].start();
        }

        try {
            for(int i = 0; i < vec.length; i++){
                vec[i].join();
            }
        } catch (Exception e) {}

        System.out.println(count);
        //COUNT puede ser 10.000, 9.753, 9.995, 9.521........ No es preciso el valor de la variable
    }
}
