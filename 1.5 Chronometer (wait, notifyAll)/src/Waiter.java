 * Created by Cristina on 09.06.2017.
 */
public class Waiter implements Runnable{
    private int timeout;
    private Time tm;

    public Waiter(Time tm, int timeout) {
        this.tm = tm;
        this.timeout = timeout;
    }

    @Override
    public void run(){
        synchronized (tm) {
            while (true) {
                try {
                    //System.out.println("Ждем вызов метода notify у Хронометра");
                    tm.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long cur_tm = tm.getTm();

                if ((cur_tm % (timeout * 1000)) < 999) {
                    System.out.println("Прошло " + timeout + " секунд");
                }
            }
        }
    }
}
