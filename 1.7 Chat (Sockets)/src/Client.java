import java.io.*;
import java.net.Socket;

/**
 * Created by Cristina on 15.06.2017.
 */
public class Client {

    public static void main(String[] ar) {

        try {
            // создаем сокет используя IP-адрес и порт сервера
            Socket socket = new Socket("127.0.0.1", 7777);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while (true) {
                System.out.print("Client : ");
                line = keyboard.readLine(); // ждем пока пользователь Клиента введет сообщение
                out.writeUTF(line); // отправляем сообщение Серверу
                out.flush();

                // если Клиент ввел "exit" - разрываем соединение
                if (line.equals("exit"))
                {
                    socket.close();
                    break;
                }

                else{
                    line = in.readUTF(); // ждем пока сервер пришлет сообщение
                    System.out.println("Server : " + line);

                    // если Сервер прислал "exit"
                    // отправляем "exit" Серверу, чтобы он тоже закрылся и разрываем соединение
                    if (line.equals("exit")){
                        out.writeUTF(line);
                        socket.close();
                        break;
                    }
                }
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
