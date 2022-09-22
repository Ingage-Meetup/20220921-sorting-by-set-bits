import jdk.jfr.Unsigned;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {
    private Kata fixture;

    @BeforeEach
    public void setUp() {
        fixture = new Kata();
    }

    @Test
    public void givenAnArrayWithOneElement_return_one_element_sorted() {
        int[] values = new int []{4};
        int[] actual = fixture.bitSort(values);
        assertEquals(4, actual[0]);
    }

    @Test
    public void givenAnArrayWithTwoElement_return_sorted() {
        int[] values = new int []{7, 6};
        int[] actual = fixture.bitSort(values);
        assertEquals(2, actual.length);
        assertEquals(6, actual[0]);
        assertEquals(7, actual[1]);
    }

    @Test
    public void givenAnArrayWithTies_return_sorted_by_bits_then_by_number() {
        int[] values = new int []{4, 2, 1};
        int[] actual = fixture.bitSort(values);
        assertEquals(3, actual.length);
        assertEquals(1, actual[0]);
        assertEquals(2, actual[1]);
        assertEquals(4, actual[2]);
    }

    @Test
    public void given_7_return_3() {
        int value = 7;
        int actual = fixture.bitCounter(value);
        assertEquals(3, actual);
    }

    @Test
    public void given_9_return_2() {
        int value = 9;
        int actual = fixture.bitCounter(value);
        assertEquals(2, actual);
    }

    @Test
    public void given_31_return_5() {
        int value = 31;
        int actual = fixture.bitCounter(value);
        assertEquals(5, actual);
    }

    @Test
    public void given_max_int_return_31() {
        int value = Integer.MAX_VALUE;
        int actual = fixture.bitCounter(value);
        assertEquals(31, actual);
    }

}
