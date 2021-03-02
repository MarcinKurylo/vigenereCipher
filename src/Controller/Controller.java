package Controller;

import Model.Decoder;
import Model.Encoder;

import java.util.Scanner;

public class Controller {

    private Scanner scanner = new Scanner(System.in);

    private void welcomeMessage(){
        System.out.println("Welcome to Vigènere Cipher App");
        System.out.println("==================");
    }

    private char chooseMode(){
        System.out.println("Choose mode - Decpypt/Encrypt:");
        while (true){
            try {
                char mode = scanner.nextLine().toUpperCase().charAt(0);
                if (mode == 'D' || mode == 'E'){
                    return mode;
                } else {
                    throw new InvalidMethodException();
                }
            } catch (InvalidMethodException e) {
                System.out.println("Invalid selector. Try again:");
            }
        }
    }

    private String getMessage(char mode){
        String displayedMode = mode == 'D' ? "decode" : "encode";
        System.out.println("Insert message to " + displayedMode + ":");
        return scanner.nextLine().toUpperCase();
    }

    private char getKey(){
        System.out.println("Choose key:");
        while (true){
            try {
                String input = scanner.nextLine().toUpperCase();
                if (input.length()>1){
                    throw new InvalidKeyException();
                }
                char key = input.charAt(0);
                if ( (int) key < 65 || (int) key > 90){
                    throw new InvalidKeyException();
                }
                return key;
            } catch (InvalidKeyException e){
                System.out.println("Invalid key. Try again: ");
            }
        }
    }



    public void run(){
        welcomeMessage();
        char mode = chooseMode();
        String message = getMessage(mode);
        char key = getKey();
        switch (mode){
            case 'D':
                Decoder decoder = new Decoder(key, message);
                String decoded = decoder.run();
                System.out.println(message + " with key: " + key + " ---> " + decoded);
                break;
            case 'E':
                Encoder encoder = new Encoder(key, message);
                String encoded = encoder.run();
                System.out.println(message + " with key: " + key + " ---> " + encoded);
                break;
            default:
                System.out.println("Something went wrong");
                break;
        }

    }

}
