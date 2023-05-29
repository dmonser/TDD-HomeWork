import org.example.PhoneBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

public class PhoneBookTest {
    Random random = new Random();
    PhoneBook phoneBook = PhoneBook.getInstance();

    @ParameterizedTest
    @MethodSource("addSource")
    public void testAdd (String name, int number, int expectedStatus) {
        System.out.println("Start add test");
        bookFill(phoneBook);

        int result = phoneBook.add(name, number);

        Assertions.assertEquals(expectedStatus, result);
    }

    @Test
    public void testFindByNumber () {
        System.out.println("Start findByNumber test");
        bookFill(phoneBook);

        String result = phoneBook.findByNumber(2080);

        Assertions.assertEquals("Test Name3", result);
    }

    @Test
    public void testFindByName () {
        System.out.println("Start findByName test");
        bookFill(phoneBook);

        int result = phoneBook.findByName("Test Name4");

        Assertions.assertEquals(1327, result);
    }

    public static Stream<Arguments> addSource() {
        return Stream.of(
                Arguments.of("Test Name5", 1811, 5),
                Arguments.of("Test Name5", 2023, 5),
                Arguments.of("Test Name6", 1960, 6)
        );
    }

    public void bookFill (PhoneBook book) {
        book.add("Test Name1", 1986);
        book.add("Test Name2", 1560);
        book.add("Test Name3", 2080);
        book.add("Test Name4", 1327);
    }
}
