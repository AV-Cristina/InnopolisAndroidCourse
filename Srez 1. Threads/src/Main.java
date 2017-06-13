import java.util.HashMap;

/**
 * Created by Cristina on 12.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        HashMap<Integer, Integer> numbers = new HashMap<>();

        Message msg = new Message(numbers, false, 0, 0);

        Counter counter = new Counter(msg);
        new Thread(counter).start();

        Generator generator = new Generator(msg);
        new Thread(generator).start();
    }

}
