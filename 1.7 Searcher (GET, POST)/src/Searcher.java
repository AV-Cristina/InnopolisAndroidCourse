import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.io.*;

/**
 * Created by Cristina on 16.06.2017.
 */
public class Main{

    public static void main(String[] args) throws Exception{
        System.out.println("GET");
        get();
        System.out.println("POST");
        post();
    }


    public static void get()  throws Exception{
        System.out.print("Введите запрос: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputQuery = reader.readLine();

        inputQuery.trim();

//        String query1 = inputQuery.replace(' ', '+');
//        System.out.println(inputQuery);

        // String replace(char oldChar, char newChar)
        StringBuilder query = new StringBuilder(inputQuery.replace(' ', '+'));

        URL url = new URL("https://www.google.ru/search?q="+query);
        URLConnection hc = url.openConnection();
        hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

        BufferedReader in = new BufferedReader(new InputStreamReader(hc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }


    public static void post()throws Exception{
        String postData = "p=Java";
        URL url = new URL("http://httpbin.org/post");
        HttpURLConnection hc = (HttpURLConnection) url.openConnection();
        hc.setRequestMethod("POST");
        hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        hc.setDoOutput(true);
        hc.setDoInput(true);

        try (DataOutputStream writer = new DataOutputStream(hc.getOutputStream())) {
            writer.writeChars(postData);
            writer.flush();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(
                hc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
