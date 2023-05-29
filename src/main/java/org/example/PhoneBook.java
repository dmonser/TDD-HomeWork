package org.example;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static PhoneBook instance = null;
    private final Map<String, Integer> book = new HashMap<>();

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

    public String findByNumber (int number) {
        if (book.size() > 0) {
            for (String key : book.keySet()) {
                if (book.get(key) == number) {
                    return key;
                }
            }
        }

        return null;
    }

    public int findByName (String name) {
        if (book.containsKey(name)) {
            return book.get(name);
        }

        return 0;
    }

    public boolean printAll () {
        if (book.size() > 0) {
            System.out.println(book.toString());
            return true;
        }

        return false;
    }
}
