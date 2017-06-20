import java.nio.file.*;
import java.util.List;

/**
 * Created by Cristina on 16.06.2017.
 */
public class Main
{
    public static void main(String[] args)  throws Exception {
        String filePath = "C:\\Users\\admin\\IdeaProjects\\MyWatchService\\src\\";
        String fileName = "text.txt";

        WatchService watchService = FileSystems.getDefault().newWatchService();

        // отслеживаемая дирректория
        Path path = Paths.get(filePath);

        printFileContent(filePath, fileName);

        // отслеживаемые события
        path.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        // если произошло какое-либо из отслеживаемых событий
        // производится вывод содержимого файла
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.context().toString().contains(fileName)){
                    System.out.println("Файл " + fileName + " был изменен:");
                    printFileContent(filePath, fileName);
                }
            }
            key.reset();
        }
    }


    // вывод содержимого файла
    public static void printFileContent(String filePath, String fileName){
        String myFullPath = filePath + fileName;
        Path path = Paths.get(myFullPath);

        try {
            List<String> content = Files.readAllLines(path);
            System.out.println(content);
        } catch (Exception e) {}
    }

}
