package vigenereCipher;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Decoder extends EncoderDecoder{

    private String toDecode;

    public Decoder(char key, String toDecode) {
        super(key);
        this.toDecode = toDecode;
    }

    public void setToDecode(String toDecode) {
        this.toDecode = toDecode;
    }

    private char decodeChar(char c1, char c2){
        int c1Ascii = getAscii(c1);
        int c2Ascii = getAscii(c2);
        int decodedAscii = 65 + (c2Ascii - c1Ascii) % 26;
        decodedAscii = decodedAscii < 65 ? decodedAscii + 26 : decodedAscii;
        return (char) decodedAscii;
    }

    private String decode(){
        CharacterIterator decodeIterator = new StringCharacterIterator(this.toDecode);
        String decoded = "";
        String key = Character.toString(this.key);
        while (decodeIterator.current() != decodeIterator.DONE){
            if (isValid(decodeIterator.current())){
                char encodedChar = decodeIterator.current();
                char keyChar = key.charAt(key.length()-1);
                char decodedChar = decodeChar(keyChar,encodedChar);
                key += decodedChar;
                decoded += decodedChar;
            } else {
                decoded += decodeIterator.current();
            }
            decodeIterator.next();
        }
        return decoded;

    }

    public String run(){
        String decoded = decode();
        return decoded;
    }


}
