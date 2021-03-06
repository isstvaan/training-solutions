package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(Path.of("bucketlist.txt"))) {
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } catch (IOException e) {
            System.out.println("Read error:" + "\n");
            e.printStackTrace();
        }
    }
}
