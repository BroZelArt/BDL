/* Реализовать многопоточное приложение “Робот”. Надо написать робота, который умеет ходить.
 За движение каждой его ноги отвечает отдельный поток. Шаг выражается в выводе в консоль
 LEFT или RIGHT. */


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Thread leftLeg = new Thread(new Leg("LEFT", 3));
        Thread rightLeg = new Thread(new Leg("RIGHT",2.5));

        leftLeg.start();
        rightLeg.start();
    }

    static class Leg implements Runnable {
        private String legName;
        private int slee;

        public Leg(String legName, double slee) {
            this.legName = legName;
            this.slee= (int) (slee*1000);
        }

        public void run() {
            while (true) {
                System.out.println(legName);
                try {
                    Thread.sleep(slee); // пауза
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


