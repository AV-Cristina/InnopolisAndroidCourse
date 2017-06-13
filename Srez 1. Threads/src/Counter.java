import java.util.HashMap;
import java.util.Map;

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
            while (true){
                try {
                    msg.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Integer number = msg.getNumber();
                msg.setNumbers(number);

                // вывод раз в 5 сек количества раз, которое каждое из чисел было сгенерированно
                if ((msg.getTime() % 5000) < 999){
                    System.out.println("Прошло " + (int)(msg.getTime()/1000) + " секунд");
                    printNum(msg.getNumbers());
                }
//                System.out.println();
//                printNum(msg.getNumbers());
            }
        }
    }

    private static void printNum(HashMap<Integer, Integer> numbers) {
        for (Map.Entry<Integer, Integer> pair : numbers.entrySet()) {
            System.out.println("Число " + pair.getKey() + " добавлено " + pair.getValue() + " раз");
        }
    }

}
