import java.nio.file.*;
import java.util.List;

/**
 * Created by Cristina on 16.06.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\admin\\IdeaProjects\\MyWatchService\\src\\";
        String fileName = "text.txt";

        // отслеживаемая дирректория
        Path path = Paths.get(filePath);

        printFileContent(filePath, fileName);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        watchKey = watchService.poll();

        WatchKey key;

        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {

                System.out.println(
                        "Event kind:" + event.kind()
                                + ". File affected: " + event.context() + ".");
                 printFileContent(filePath, fileName);
//                if (fileName.equals(event.context())){
//                    System.out.println("Файл " + fileName + " был изменен:");
//                    printFileContent(filePath, fileName);
//                }
            }
            key.reset();
        }
    }


    public static void printFileContent(String filePath, String fileName){
        String myFullPath = filePath + fileName;
        Path path = Paths.get(myFullPath);

        try {
            List<String> content = Files.readAllLines(path);
            System.out.println(content);
        } catch (Exception e) {}
    }
}
