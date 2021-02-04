package week13d03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AuthorMostPagesTest {
    @Test
    public void testBookSelector() {
        AuthorMostPages bs = new AuthorMostPages();
        String author = bs.getMostPagesAuthor(
                Arrays.asList(
                        new Book("Rejtő Jenő", "Elveszett cirkáló", 155),
                        new Book("Rejtő Jenő", "Piszkos Fred a kapitány", 175),
                        new Book("Rejtő Jenő", "Utolsó helyőrség", 187),
                        new Book("Friderikusz", "Majmok bolygója: Főld", 185)
                )
        );
        assertEquals("Rejtő Jenő", author);
    }

}
