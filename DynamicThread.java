import java.util.Random;

public class DynamicThread extends Thread {

    private static int tam = 4;
    private static int[][] matrix = new int[tam][tam];
    private int init, fin;

    public DynamicThread(int init, int fin) {
        this.init = init;
        this.fin = fin;
    }

    @Override
    public void run() {

        //Multiplica los valores internos de la matriz por 10
        for (int i = init; i < fin; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= 10;
            }
        }
    }

    static class ProcedureExit extends Thread {

        int tamano;
        int[][] valor = new int[tamano][tamano];

        @Override
        public void run() {

            for (int i = 0; i < valor.length; i++) {
                for (int j = 0; j < valor[0].length; j++) {
                    System.out.print(valor[i][j] + " ");
                }
                System.out.println();
            }

        }

        public void ValorCondicion(int[][] matrix, int tam) {
            this.valor = matrix;
            this.tamano = tam;
        }
    }

    public static void main(String[] args) {

        //Clase encargada de obtener la cantidad de hardware que tiene la maquina donde se esta ejecutando JAVA
        Runtime runtime = Runtime.getRuntime();

        //Obtiene la cantidad de nucleos que tiene asociado la maquina
        int core = runtime.availableProcessors();

        //Generador de numeros de forma ramdon o aleatoria
        Random rand = new Random(System.nanoTime());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = rand.nextInt(20);
            }
        }

       
        //Se crea un vector que contiene los la cantidad de nucleos logicos del pc
        Thread[] numberThread = new Thread[core];

        int range = tam / core; 
        int start = 0;
        int finish = range;

        for(int i = 0; i < core; i++){
            //Inicializar los hilos en base a los nucleos del equipo
            if( i != core - 1){
                numberThread[i] = new DynamicThread(start, finish);
                numberThread[i].start();
    
                start = finish;
                finish += range;

            } else {

                numberThread[i] = new DynamicThread(start, tam);
                numberThread[i].start();
            }
        }

        for(int i = 0; i < core; i++){
            try {
                numberThread[i].join();
            } catch (Exception e) {}
        }

        ProcedureExit exit = new ProcedureExit();
        exit.ValorCondicion(matrix, tam);
        exit.start();
    }
}
