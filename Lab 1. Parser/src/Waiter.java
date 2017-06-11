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

    public Waiter(Message msg, String filePath) {
        this.msg = msg;
        this.filePath = filePath;
    }


    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), "windows-1251"))){

            String line;

            while ((line = reader.readLine()) != null) {
                for (String word : line.split(" ")) {

                    if (wordCheck(word)) {
                        synchronized (msg) {
                            try {
                                msg.wait();
                                if (msg.addWord(word)){
                                    System.out.println("Добавлено слово: " + word);
                                }
                                else {
                                    msg.setCorrect(false);
                                    System.out.println("Слово: " + word + " уже было добавлено ранее");
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else {
                        msg.setCorrect(false);
                        System.out.println("Текст не должен содержать инностранных символов, только кириллицу, знаки препинания и цифры");
                    }
                }
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