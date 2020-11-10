package stringbasic;

import java.util.ArrayList;
import java.util.List;

public class Vet {
    List<Pet> pets = new ArrayList<>();

    public void add(Pet pet) {
        for (Pet petsItem : pets) {
            if (areEqual(petsItem, pet)) {
                return;
            }
        }
        pets.add(pet);
    }

    private boolean areEqual(Pet pet1, Pet pet2) {
        return pet1.getRegNumber().equals(pet2.getRegNumber());
    }

    public List<Pet> getPets() {
        return pets;
    }
}
