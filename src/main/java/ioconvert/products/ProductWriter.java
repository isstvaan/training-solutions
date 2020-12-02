package ioconvert.products;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream fileStream, List<Product> products) {
        if (fileStream == null) {
            throw new IllegalArgumentException("File stream can't be null");
        }
        if (products == null) {
            throw new IllegalArgumentException("Products can't be null");
        }

        try (PrintStream stream = new PrintStream(new BufferedOutputStream(fileStream))) {
            for (Product item : products) {
                stream.println(item);
            }
        }
    }
}
