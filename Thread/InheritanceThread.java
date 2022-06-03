package Thread;
public class InheritanceThread extends Thread {

    private String word; // Lo que va a escribir.
    private int delay; // Tiempo entre escrituras

    public InheritanceThread(String queDecir, int cadaCuantosMs) {

        word = queDecir;
        delay = cadaCuantosMs;
    };


    @Override
    public void run(){ //Se sobrescribe run() de Thread

        while(true){

            System.out.print(word + " " + delay);
            try{

                sleep(delay);

            } catch(InterruptedException e){ 

                return; 
            }
        }
    }

}
