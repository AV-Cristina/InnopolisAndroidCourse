/**
 * Created by Cristina on 12.06.2017.
 */
public class Generator implements Runnable{

    private Message msg;

    public Generator(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Генератор запустился");

        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (msg) {
                    if (msg.isFiveTimes == false){
                        msg.setNumber((rnd(11)));
                        msg.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int rnd(int max)
    {
        return (int) (Math.random() * ++max) + 0;
    }
}
