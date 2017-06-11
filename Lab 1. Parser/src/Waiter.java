import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Cristina on 11.06.2017.
 */
public class Waiter implements  Runnable{

    private Message msg;
    private String filePath;
    private static volatile boolean exitFlag = false;
    String name;


    public Waiter(Message msg, String filePath) {
        this.msg = msg;
        this.filePath = filePath;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(System.currentTimeMillis() + ": "+ name + ": Стартовал поток waiter");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), "windows-1251"))){

            String line;

            while (((line = reader.readLine()) != null) && (exitFlag != true)) {
                for (String word : line.split(" ")) {
                    if (exitFlag) { break; }
                    if (wordCheck(word)) {
                        if (exitFlag) { break; }
                        System.out.println(System.currentTimeMillis() + ": "+ name + ": Проверка слова (" + word + ") = true");
                        synchronized (msg) {

                            System.out.println(System.currentTimeMillis() + ": "+ name + ": запись begin");
                            if (msg.addWord(word)){
                                System.out.println(System.currentTimeMillis() + ": "+ name + ": Добавлено слово: " + word);
                            }
                            else {
                                msg.setCorrect(false);
                                System.out.println(System.currentTimeMillis() + ": "+ name + ": Слово: " + word + " уже было добавлено ранее");
                                exitFlag=true;
                                break;
                            }

                            System.out.println(System.currentTimeMillis() + ": "+ name + ": запись end");
                        }

                    }
                    else {
                        System.out.println(System.currentTimeMillis() + ": "+ name + ": Проверка слова (" + word + ") = false");
                        System.out.println(System.currentTimeMillis() + ": "+ name + ": Текст не должен содержать иностранных символов, только кириллицу, знаки препинания и цифры " + word);
                        exitFlag=true;
                        break;
                    }
                }
                if (exitFlag) { break; }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean wordCheck (String word){
        Pattern pattern = Pattern.compile(
                "[" +                   //начало списка допустимых символов
                        "а-яА-ЯёЁ" +    //буквы русского алфавита
                        "\\d" +         //цифры
                        "\\s" +         //знаки-разделители (пробел, табуляция и т.д.)//
                        "\\p{Punct}" +  //знаки пунктуации
                        "]" +                   //конец списка допустимых символов
                        "*");                   //допускается наличие указанных символов в любом количестве

        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

}
