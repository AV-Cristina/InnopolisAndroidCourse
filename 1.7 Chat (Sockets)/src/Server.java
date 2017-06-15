import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Cristina on 15.06.2017.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(7777); // создаем сокет сервера
            Socket socket = serverSocket.accept(); // заставляем сервер ждать подключений

            // Берем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // Конвертируем потоки в другой тип, чтобы обрабатывать текстовые сообщения
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            // Создаем поток для чтения с клавиатуры
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            boolean isConnect = true;

            while (isConnect) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста и выводим
                System.out.println("Client : " + line);

                if (line.equals("exit"))
                {
                    isConnect = false;
                    serverSocket.close();
                    break;
                }
                else {
                    System.out.print("Server : ");
                    line = keyboard.readLine(); // ждем пока пользователь Сервера введет сообщения
                    if (line.equals("exit")) {
                        isConnect = false;
                        serverSocket.close();
                        break;
                    }
                    else {
                         out.writeUTF(line); // отсылаем клиенту введенную строку
                         out.flush(); // заставляем поток закончить передачу данных
                    }
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
