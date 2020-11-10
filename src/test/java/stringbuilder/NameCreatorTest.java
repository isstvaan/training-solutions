package stringbuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameCreatorTest {

    @Test
    public void westernStyleNameConcatenation() {

        assertEquals("Mr. John G Smith", new NameCreator().concatNameWesternStyle("Smith", "G", "John", Title.MR));
        assertEquals("John G Smith", new NameCreator().concatNameWesternStyle("Smith", "G", "John", null));
        assertEquals("Mr. John Smith", new NameCreator().concatNameWesternStyle("Smith", "", "John", Title.MR));
        assertEquals("Mr. John Smith", new NameCreator().concatNameWesternStyle("Smith", null, "John", Title.MR));
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        assertEquals("Mr. Smith G John", new NameCreator().concatNameHungarianStyle("Smith", "G", "John", Title.MR));
        assertEquals("Smith G John", new NameCreator().concatNameHungarianStyle("Smith", "G", "John", null));
        assertEquals("Mr. Smith John", new NameCreator().concatNameHungarianStyle("Smith", "", "John", Title.MR));
        assertEquals("Mr. Smith John", new NameCreator().concatNameHungarianStyle("Smith", null, "John", Title.MR));
    }

    @Test
    public void insertTitle() {
        //Given
        String name = "John G Smith";
        //Then
        assertEquals("Dr. John G Smith", new NameCreator().insertTitle(name, Title.DR, " "));
    }

    @Test
    public void deleteNamePart() {

        assertEquals("Dr. John G Smith", new NameCreator().deleteNamePart("Dr. Prof. John G Smith", "Prof. "));
    }
}
