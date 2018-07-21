package others;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurrencyTest {
    private static final Currency tester = new Currency();

    @Test
    void simpleTest1() {
        assertEquals("1,234", tester.printCurrency("1234"));
    }

    @Test
    void simpleTest2() {
        assertEquals("1,234.1", tester.printCurrency("1234.1"));
    }

    @Test
    void simpleTest3() {
        assertEquals("1,234.12", tester.printCurrency("1234.12"));
    }

    @Test
    void simpleTest4() {
        assertEquals("1,234.12", tester.printCurrency("1234.123"));
    }

    @Test
    void simpleTest5() {
        assertEquals("1,234.13", tester.printCurrency("1234.127"));
    }

    @Test
    void simpleTest6() {
        assertEquals("1,234.20", tester.printCurrency("1234.198"));
    }
}