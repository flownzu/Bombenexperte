import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Terminal {

    private static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    
    private Terminal() {
    }
    
    public static void printLine(String out) {
        System.out.println(out);
    }
    
    public static String readLine() {
        try {
        	String Eingabe = in.readLine();
            return Eingabe;
        } catch (IOException e) {
            System.out.println("Error, an exception occured during input.");
            return null;
        }
    }
}