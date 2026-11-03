import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pG {
    public static void main(String[] args) {
        try {
            BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
            String palabra = lee.readLine();

            String invertida = new StringBuilder(palabra).reverse().toString();
            System.out.println(invertida);
        } catch (IOException e) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        }
    }
}
