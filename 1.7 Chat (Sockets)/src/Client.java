import java.io.*;
import java.net.Socket;

/**
 * Created by Cristina on 15.06.2017.
 */
public class Client {

    public static void main(String[] ar) {

        try {
            Socket socket = new Socket("127.0.0.1", 7777); // создаем сокет используя IP-адрес и порт сервера.

            // Берем входной и выходной потоки сокета
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
                System.out.print("Client : ");
                line = keyboard.readLine(); // ждем пока пользователь Клиента введет сообщение
                out.writeUTF(line); // отсылаем введенную строку текста Серверу
                out.flush(); // заставляем поток закончить передачу данных
                if (line.equals("exit"))
                {
                    isConnect = false;
                    socket.close();
                    break;
                }
                else{
                    line = in.readUTF(); // ждем пока сервер пришлет строку
                    System.out.println("Server : " + line);

                    if (line.equals("exit")){
                        isConnect = false;
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
