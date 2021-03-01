package vigenereCipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    private Encoder encoder;
    public static int count=1;
    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        encoder = new Encoder('N', "TO JEST BARDZO TAJNY TEKST");
        System.out.println("Running a test no " + count++);
    }

    @Test
    void testGetAscii(){
        int ascii = encoder.getAscii('Z');
        assertEquals(90, ascii);
    }


    @Test
    void testRun() {
        String encoded = encoder.run();
        assertEquals("GH XNWL UBRUCN HTJWL RXOCL", encoded);
        encoder.setToEncode("TO.,,,.42.JEST BARDZO TAJNY TEKST");
        encoded = encoder.run();
        assertEquals("GH.,,,.42.XNWL UBRUCN HTJWL RXOCL", encoded);
        encoder.setToEncode("123456789");
        encoded = encoder.run();
        assertEquals("123456789", encoded);
    }

}