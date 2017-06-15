import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Cristina on 15.06.2017.
 */
public class Searcher {

    public static void main(String[] args) throws Exception {
        System.out.print("Введите запрос: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String query = reader.readLine();

        String getQuery = "GET /search?q=" + query + "&output=xml&client=test&site=operations HTTP/1.0";
        //GET /search?q=bill+material&output=xml&client=test&site=operations HTTP/1.0

        System.out.println(downloadUrl("https://www.google.ru/", query));
    }


    private static InputStream downloadUrl(String urlString, String query) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 );
        conn.setConnectTimeout(15000 );
        String getQuery = query;
        conn.setRequestMethod(getQuery);
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }
}

