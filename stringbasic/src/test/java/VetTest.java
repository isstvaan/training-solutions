import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VetTest {

    @Test
    public void testAddDifferent() {
        Vet vet = new Vet();

        vet.add(new Pet("Blöki",2017, Pet.Gender.MALE, "000145"));
        vet.add(new Pet("Szerénke", 2012, Pet.Gender.FEMALE, "000129"));

        assertEquals(2, vet.getPets().size());
    }

    @Test
    public void testAddSame() {
        Vet vet = new Vet();

        vet.add(new Pet("Blöki", 2017, Pet.Gender.MALE, "000145"));
        vet.add(new Pet("Szerénke", 2012, Pet.Gender.FEMALE, "000145"));

        assertEquals(1, vet.getPets().size());
    }
}
