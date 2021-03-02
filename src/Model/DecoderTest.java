package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private Decoder decoder;
    public static int count=1;
    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        decoder = new Decoder('N', "GH XNWL UBRUCN HTJWL RXOCL");
        System.out.println("Running a test no " + count++);
    }

    @Test
    void testRun() {
        String encoded = decoder.run();
        assertEquals("TO JEST BARDZO TAJNY TEKST", encoded);
        decoder.setToDecode("GH.,,,.42 XNWL UBRUCN HTJWL RXOCL");
        encoded = decoder.run();
        assertEquals("TO.,,,.42 JEST BARDZO TAJNY TEKST", encoded);
        decoder.setToDecode("123456789");
        encoded = decoder.run();
        assertEquals("123456789", encoded);
    }
}