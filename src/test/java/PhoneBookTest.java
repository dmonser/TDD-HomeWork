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

    @ParameterizedTest
    @MethodSource("addSource")
    public void testAdd (String name, int number, int expectedStatus) {
        System.out.println("Start add test");
        PhoneBook phoneBook = PhoneBook.getInstance();

        int result = phoneBook.add(name, number);

        Assertions.assertEquals(expectedStatus, result);
    }

    @Test
    public void testFindByNumber () {
        PhoneBook phoneBook = PhoneBook.getInstance();
        bookFill(phoneBook);

        String result = phoneBook.findByNumber(2080);

        Assertions.assertEquals("Test Name3", result);
    }

    @Test
    public void testFindByName () {
        PhoneBook phoneBook = PhoneBook.getInstance();
        bookFill(phoneBook);

        int result = phoneBook.findByName("Test Name4");

        Assertions.assertEquals(1327, result);
    }

    public static Stream<Arguments> addSource() {
        return Stream.of(
                Arguments.of("Test Name1", 1986, 1),
                Arguments.of("Test Name2", 1560, 2),
                Arguments.of("Test Name3", 2080, 3),
                Arguments.of("Test Name3", 2014, 3),
                Arguments.of("Test Name4", 1327, 4)
        );
    }

    public void bookFill (PhoneBook book) {
        book.add("Test Name1", 1986);
        book.add("Test Name2", 1560);
        book.add("Test Name3", 2080);
        book.add("Test Name4", 1327);
    }
}
