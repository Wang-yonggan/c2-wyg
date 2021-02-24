import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : Task8
 * @Author : wang-yonggan
 * @Date: 2021-02-21 22:23
 */

public class Task8 {
    public static void main(String[] args) {
        //写入内容
        BufferedWriter bf;
        try (FileWriter fw = new FileWriter("C:\\csatest\\demo.txt")) {
            bf = new BufferedWriter(fw);
            bf.write("csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa20" +
                    "21csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2" +
                    "021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021csa2021");
            bf.close();
            System.out.println("写入成功");
            //查询有多少个2021
            List<String> all_line = new LinkedList<>();
            String all_content = "";
            all_line = Files.readAllLines(Paths.get("C:\\csatest\\demo.txt"));
            for (String str : all_line)
                all_content += str;
            int len = all_content.split("2021").length;
            if (!all_content.endsWith("2021")) len--;
            System.out.printf("共有%d个2021", len);
        } catch (IOException e) {
            System.out.println("文件读写错误");
            e.printStackTrace();
        }


    }
}
