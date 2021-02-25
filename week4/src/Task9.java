import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @ClassName : Task9
 * @Author : wang-yonggan
 * @Date: 2021-02-24 15:40
 */

public class Task9 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("C:\\csatest\\demo2.txt");) {
            List<String> all_line = Files.readAllLines(Paths.get("C:\\csatest\\demo.txt"));
            for (String line : all_line)
                fw.write(line);
            System.out.println("写入成功");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
