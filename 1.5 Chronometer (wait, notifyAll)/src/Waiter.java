/**
 * Created by Cristina on 09.06.2017.
 */
public class Waiter implements Runnable{
    private int interval;
    private Time tm;

    public Waiter(Time tm) {
        this.tm = tm;
    }

    @Override
    public void run(){
        synchronized (tm) {
            for (int i = 0; i < 16; i++) {
                try {
                    //System.out.println("Ждем вызов метода notify у Хронометра");
                    tm.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Хронометр передал: " + tm.getTm());

                long cur_tm = tm.getTm();
                if ((cur_tm % 5000) < 999) {
                    System.out.println("Прошло 5 секунд");
                }
            }
        }
    }
}
