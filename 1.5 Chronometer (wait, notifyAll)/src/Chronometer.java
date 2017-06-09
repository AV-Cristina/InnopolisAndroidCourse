/**
 * Created by Cristina on 09.06.2017.
 */
public class Chronometer implements Runnable {

    private Time tm;

    public Chronometer(Time tm){
        this.tm = tm;
    }

    @Override
    public void run() {
        System.out.println("Хронометр запустился");
        long startSession = System.currentTimeMillis();
        for (int i = 0; i < 16; i++) {
            try {
                Thread.sleep(1000);
                synchronized (tm) {
                    long timeAfterStart = System.currentTimeMillis() - startSession;
                    System.out.println(i+1 + ") С начала сессии прошло: " + timeAfterStart);
                    tm.setTm(timeAfterStart);
                    tm.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
