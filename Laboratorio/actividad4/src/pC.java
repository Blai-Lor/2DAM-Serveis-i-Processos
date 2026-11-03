import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class pC {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escribe un texto:");
            String texto = sc.nextLine();

            ProcessBuilder pb = new ProcessBuilder("java", "pD.java");
            pb.redirectErrorStream(true);
            Process proceso = pb.start();

            BufferedWriter escrito = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            escrito.write(texto);
            escrito.newLine();
            escrito.flush();
            escrito.close(); 

            BufferedReader lee = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String estaLinea;
            while ((estaLinea = lee.readLine()) != null) {
                System.out.println("Salida del hijo: " + estaLinea);
            }

            proceso.waitFor();

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso hijo ha tenido un error.");
            System.exit(-1);
        }
    }
}
