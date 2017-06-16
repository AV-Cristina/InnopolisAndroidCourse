import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Cristina on 16.06.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        ArrayList<String> filePathList = new ArrayList<>();

        filePathList.add("C:\\Users\\admin\\IdeaProjects\\SumEvenAndPositiveNum\\src\\Data\\data000.txt");
        filePathList.add("C:\\Users\\admin\\IdeaProjects\\SumEvenAndPositiveNum\\src\\Data\\data001.txt");
        filePathList.add("C:\\Users\\admin\\IdeaProjects\\SumEvenAndPositiveNum\\src\\Data\\data002.txt");

        Message msg = new Message(0);

        CopyOnWriteArrayList<Integer> numList = new CopyOnWriteArrayList<>();

        for (int i = 0; i < filePathList.size(); i++)
        {
            Counter counter = new Counter(msg, filePathList.get(i), numList);
            new Thread(counter::run).start();
        }

    }
}
