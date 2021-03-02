package Model;

public abstract class EncoderDecoder {

    protected final char key;

    public EncoderDecoder(char key) {
        this.key = Character.toUpperCase(key);
    }

    protected int getAscii(char c){
        return (int) c;
    }

    protected boolean isValid(char c){
        return getAscii(c) >= 65 && getAscii(c) <= 90;
    }
}
