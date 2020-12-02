package ioconvert.shopping;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListManager {

    public void saveShoppingList(OutputStream fileStream, List<String> items) {
        if (fileStream == null) {
            throw new IllegalArgumentException("File stream can't be null");
        }
        if (items == null) {
            throw new IllegalArgumentException("Items can't be null");
        }

        try (PrintStream stream = new PrintStream(new BufferedOutputStream(fileStream))) {
            for (String item : items) {
                stream.println(item);
            }
        }
    }

    public List<String> loadShoppingList(InputStream fileStream) {
        if (fileStream == null) {
            throw new IllegalArgumentException("File stream can't be null");
        }
        List<String> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(fileStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                items.add(line);
            }

        } catch (IOException e2) {
            throw new IllegalStateException("Cannot read entry", e2);
        }
        return items;
    }
}
