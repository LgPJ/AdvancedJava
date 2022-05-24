import java.util.Random;

public class TimeAndConcurrence extends Thread {

    private static int tam = 1000;
    private static int[][] matrix = new int[tam][tam];
    private int init, fin;

    public TimeAndConcurrence(int init, int fin) {
        this.init = init;
        this.fin = fin;
    }

    @Override
    public void run() {

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

        double timeInit, timeFin;

        Random rand = new Random(System.nanoTime());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = rand.nextInt(20);
            }
        }

        // Medir el tiempo desde esta bandera de inicio, se inicia desde el momento
        // cuando el programa pasa por aqui
        // Esto regresa la hora en NanoSegundos
        timeInit = System.nanoTime();

        TimeAndConcurrence prin = new TimeAndConcurrence(0, 500);
        TimeAndConcurrence prin2 = new TimeAndConcurrence(500, 1000);

        ProcedureExit data = new ProcedureExit();
        data.ValorCondicion(matrix, tam);

        // Ejecucion de Hilos
        prin.start();
        prin2.start();
       
        try {
            // Se determina que el hilo principal debe esperar la finalizacion de los demas
            // hilos
            prin.join();
            prin2.join();
            data.join();
        } catch (Exception e) {
        }

        // retorna la hora en que el programa pasa por este punto y le restamos la hora
        // de inicio
        timeFin = System.nanoTime() - timeInit;

        System.out.println((timeFin / 1000000) + "MILISEGUNDOS");
    }
}
