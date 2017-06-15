import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Cristina on 15.06.2017.
 * Первым необходимо запускать Сервер
 * Первым отправку сообщений должен начать Клиент
 * Для выхода ввести "exit"
 */
public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(7777); // создаем сокет сервера
            Socket socket = serverSocket.accept(); // заставляем сервер ждать подключений

            // Входной и выходной потоки сокета
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтобы обрабатывать текстовые сообщения
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста и выводим
                System.out.println("Client : " + line);

                if (line.equals("exit"))
                {
                    serverSocket.close();
                    break;
                }
                else {
                    System.out.print("Server : ");
                    line = keyboard.readLine(); // ждем пока пользователь Сервера введет сообщения

                    out.writeUTF(line); // отсылаем клиенту
                    out.flush(); // заставляем поток закончить передачу данных
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
