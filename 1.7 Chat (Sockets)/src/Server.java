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
        try(
            ServerSocket serverSocket = new ServerSocket(7777); // создаем сокет сервера
            Socket socket = serverSocket.accept(); // заставляем сервер ждать подключений
            DataInputStream in = new DataInputStream(socket.getInputStream()); // входной поток сокета
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // выходной поток сокета
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String line;

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

                    out.writeUTF(line); // отсылаем сообщение Клиенту
                    out.flush(); // заставляем поток закончить передачу данных
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
