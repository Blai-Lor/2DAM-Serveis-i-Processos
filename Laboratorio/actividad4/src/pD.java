import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pD {
    public static void main(String[] args) {
        try {
            BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
            String texto = lee.readLine();

            System.out.println(texto.toUpperCase());
        } catch (IOException e) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        }
    }
}