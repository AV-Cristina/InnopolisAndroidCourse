import java.io.*;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Cristina on 16.06.2017.
 */
public class Counter implements Runnable{

    private Message msg;
    private String filePath;
    private static volatile boolean exitFlag = false;
    private CopyOnWriteArrayList numList;


    public Counter(Message msg, String filePath, CopyOnWriteArrayList numList){
        this.msg = msg;
        this.filePath = filePath;
        this.numList = numList;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(System.currentTimeMillis() + " : Стартовал поток Counter #" + threadName);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), "windows-1251"))){

            String line;

            while(((line = reader.readLine()) != null) && (exitFlag != true)) {
                if (!numCheck(line))
                {
                    exitFlag = true;
                    msg.setCorrect(false);
                    System.out.println(System.currentTimeMillis() + " Counter #" + threadName + " : В файле " +
                        filePath+ " содержатся недопустимые символы");
                    break;
                }
                else{
                    Scanner scan = new Scanner(line);
                    while(scan.hasNextInt()) {
                        if (exitFlag) { break; }

                        Integer num = Integer.parseInt(scan.next());

                        if ((num > 0) && (num % 2 == 0)){
                            if (exitFlag){ break;}
                            else {
                                 System.out.println(System.currentTimeMillis() + " Counter #" + threadName +" : считал  " +num);
                                 numList.add(num);

                                 // Создание стрима из коллекции
                                 Collection<Integer> numCollection = numList;
                                 Integer numSum = numCollection.stream().reduce(0, (s1, s2) -> s1 + s2);

                                 synchronized (msg) {
                                     msg.setSum(numSum);
                                 }
                                 System.out.println(System.currentTimeMillis() + " Counter #" + threadName +" : Сумма =  " + numSum);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean numCheck (String line){
        Pattern pattern = Pattern.compile(
                "[" +
                        "\\d" +         //цифры
                        "\\s" +         //знаки-разделители (пробел, табуляция и т.д.) //
                        "\\p{Punct}" +  //знаки пунктуации
                        "]" +
                        "*");           //допускается наличие указанных символов в любом количестве

        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

}
