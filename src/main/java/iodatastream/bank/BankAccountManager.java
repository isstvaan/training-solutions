package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path path) {
        if (account == null) {
            throw new IllegalArgumentException("Account can't be null");
        }

        try (DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path.resolve(account.getAccountNumber() + ".dat"))))) {
            stream.writeUTF(account.getAccountNumber());
            stream.writeUTF(account.getOwner());
            stream.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    public BankAccount loadAccount(InputStream inputStream) {
        if (inputStream == null) {
            throw new IllegalArgumentException("Input stream is null");
        }

        try (DataInputStream stream = new DataInputStream(new BufferedInputStream(inputStream))) {
            return new BankAccount(stream.readUTF(), stream.readUTF(), stream.readDouble());
        } catch (IOException e) {
            throw new IllegalStateException("File read error.", e);
        }

    }
}
