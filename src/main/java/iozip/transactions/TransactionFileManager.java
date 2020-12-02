package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {
    public void saveTransactions(Path file, List<Transaction> transactions) {
        if (file == null) {
            throw new IllegalArgumentException("File can't be null");
        }

        if (transactions == null) {
            throw new IllegalArgumentException("Transactions can't be null");
        }

        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Transaction item : transactions) {
                zip.putNextEntry(new ZipEntry(String.valueOf(item.getId())));
                zip.write(item.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
