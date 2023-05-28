package org.example;

public class PhoneBook {

    private static PhoneBook instance = null;

    private PhoneBook () {

    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            instance = new PhoneBook();
        }
        return instance;
    }

    public int add (String name, int number) {
        return 0;
    }
}
