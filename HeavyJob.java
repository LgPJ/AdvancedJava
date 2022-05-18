
import java.util.*;

class HeavyJob {

    private String workerName;

    public HeavyJob(String workerName) {

        this.setWorkerName(workerName);

    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String process(int object) {

        int num = (int) (Math.random() * 2000 + 1000);

        try {

            Thread.sleep(num);

        } catch (InterruptedException e) {

            System.out.println(e);
        }

        return String.valueOf(object);

    }

    static class ProcedureExit extends Thread {

        List<String> listHeavyJobs = new ArrayList<>();

        @Override
        public void run() {

            int num = (int) (Math.random() * 2000 + 1000);

            for (int i = 14; i >= 0; i--) {

                System.out.print(" " + listHeavyJobs.get(i) + " ");

                try {

                    Thread.sleep(num);

                } catch (InterruptedException e) {

                    System.out.println(e);
                }

            }
            System.out.println();
        }

        public void ValorCondicion(List<String> valor) {
            this.listHeavyJobs = valor;
        }
    }

    public static void main(String[] args) {

        List<String> listHeavyJobs = new ArrayList<>();
        int num = (int) (Math.random() * 2000 + 1000);

        for (int i = 0; i < 15; i++) {

            HeavyJob heavy = new HeavyJob("Name");

            listHeavyJobs.add(heavy.process(i));

            System.out.print(" " + listHeavyJobs.get(i) + " ");

            try {

                Thread.sleep(num);

            } catch (InterruptedException e) {

                System.out.println(e);
            }
        }
        System.out.println();

        ProcedureExit reverse = new ProcedureExit();
        reverse.ValorCondicion(listHeavyJobs);
        reverse.start();
    }
}
