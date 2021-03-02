package Model;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Encoder extends EncoderDecoder {

    private String toEncode;

    public Encoder(char key, String toEncode) {
        super(key);
        this.toEncode = toEncode.toUpperCase();
    }

    public void setToEncode(String toEncode){
        this.toEncode = toEncode.toUpperCase();
    }

    private char encodeChar(char c1, char c2){
        int c1Ascii = getAscii(c1);
        int c2Ascii = getAscii(c2);
        int encodedAscii = 65 + (c1Ascii + c2Ascii) % 26;
        return (char) encodedAscii;
    }



    private String generateStringKey(){
        CharacterIterator iterator = new StringCharacterIterator(this.toEncode);
        String stringKey = Character.toString(this.key);
        while (iterator.getIndex() < iterator.getEndIndex()-1) {
            if (isValid(iterator.current())) {
                stringKey += iterator.current();
            }
            iterator.next();
        }
        return stringKey;
    }


    private String encode(){

        CharacterIterator encodeIterator = new StringCharacterIterator(this.toEncode);
        CharacterIterator stringKeyIterator = new StringCharacterIterator(generateStringKey());
        String encoded = "";
        while (encodeIterator.current() != encodeIterator.DONE){
            char currentChar = encodeIterator.current();
            encodeIterator.next();
            if (isValid(currentChar)){
                char currentKeyChar = stringKeyIterator.current();
                stringKeyIterator.next();
                encoded += encodeChar(currentChar,currentKeyChar);
            } else {
                encoded += currentChar;
            }
        }
        return encoded;
    }

    public String run(){
        return encode();
    }

}
