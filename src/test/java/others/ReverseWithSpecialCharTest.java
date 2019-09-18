package others;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ReverseWithSpecialCharTest {
    private ReverseWithSpecialChar tester = new ReverseWithSpecialChar();

    @Test
    void simpleTest() {
        assertEquals("", tester.reverse(""));
        assertEquals(",./", tester.reverse(",./"));
        assertEquals("c,b$a", tester.reverse("a,b$c"));
        assertEquals("ed,c,bA!$", tester.reverse("Ab,c,de!$"));
    }
}
