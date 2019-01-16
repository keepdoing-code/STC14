package lections.lec03.Generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenTest {
    public static void main(String[] args) {
        List<Cat> cats = getPets();
        List<Pet> pets = new ArrayList<>(cats);
        pets.add(new Dog());
        Collections.copy(pets, cats);
        callPets(pets);
    }

    private static void callPets(List<? extends Pet> pets) {
        pets.forEach(Pet::call);
    }

    private static List<Cat> getPets() {
        List<Cat> result = new ArrayList<>();
        result.add(new Cat());
        return result;
    }
}
