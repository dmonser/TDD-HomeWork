package org.example;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static PhoneBook instance = null;
    private final HashMap<String, Integer> book = new HashMap<>();

    private PhoneBook () {

    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    public int add (String name, int number) {
        book.put(name, number);

        return book.size();
    }
}
