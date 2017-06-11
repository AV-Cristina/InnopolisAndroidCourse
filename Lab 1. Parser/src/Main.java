/**
 * Created by Cristina on 11.06.2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {

            ArrayList<String> filePathList = new ArrayList<>();

            int fileCount = 3;

            filePathList.add("C:\\Users\\admin\\IdeaProjects\\Parser\\src\\Data\\data000.txt");
            filePathList.add("C:\\Users\\admin\\IdeaProjects\\Parser\\src\\Data\\data001.txt");
            filePathList.add("C:\\Users\\admin\\IdeaProjects\\Parser\\src\\Data\\data002.txt");

            /*
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            for (int i = 1; i <= fileCount; i++)
            {
                try {
                    System.out.print("Введите путь к " + i + " файлу:" );
                    String filePath = reader.readLine();
                    filePathList.add(filePath);
                }
                catch (IOException e){
                    System.out.println("Произошла ошибка");
                    e.printStackTrace();
                }
            }
            */

            ArrayList<String> wordList = new ArrayList<>();

            Message msg = new Message(wordList, true);

            for (int i = 0; i < fileCount; i++)
            {
                Waiter waiter = new Waiter(msg, filePathList.get(i));
                new Thread(waiter).start();
            }

            Notifier notifier = new Notifier(msg);
            new Thread(notifier).start();
        }
    }