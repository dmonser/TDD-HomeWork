import org.example.PhoneBook;
import org.junit.jupiter.api.Assertions;
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

    public static Stream<Arguments> addSource() {
        return Stream.of(
                Arguments.of("Test Name1", 1986, 1),
                Arguments.of("Test Name2", 1560, 2),
                Arguments.of("Test Name3", 2080, 3),
                Arguments.of("Test Name3", 2014, 3),
                Arguments.of("Test Name5", 1327, 4)
        );
    }
}
