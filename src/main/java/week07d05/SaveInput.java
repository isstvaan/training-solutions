package week07d05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class SaveInput {

    public static void saveInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String[] userInputs = new String[3];

        System.out.println("Kérek " + userInputs.length + " sort amit a fájlba írhatok:");

        for (int i = 0; i < userInputs.length; i++) {
            System.out.println(i + 1 + " sor:");
            userInputs[i] = scanner.nextLine();
        }

        System.out.println("Köszönöm.\nMost pedig kérném a fájl nevét, ahová elmenthetem");
        String fileName = scanner.nextLine();
        saveFile(userInputs, fileName);
    }

    private static void saveFile(String[] datas, String fileName) {
        Path savePath = Path.of(/*SAVE_FILE_PATH +*/ fileName);

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                Files.newOutputStream(savePath, StandardOpenOption.CREATE))))) {
            for (String data : datas) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not create the file:" + savePath.toString(), ioException);
        }
    }

    public static void main(String[] args) {
        saveInputFromConsole();
    }
}
