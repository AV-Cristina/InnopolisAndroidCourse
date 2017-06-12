/**
 * Created by Cristina on 12.06.2017.
 */
public class Counter implements Runnable{

    private Message msg;

    public Counter(Message msg){
        this.msg = msg;
    }

    @Override
    public void run(){
        synchronized (msg) {
            while (true) {
                try {
                    msg.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer number = msg.getNumber();
                if (msg.setNumders(number)){
                    System.out.println(System.currentTimeMillis() + " Добавлено " + number);
                }
            }
        }
    }
}
