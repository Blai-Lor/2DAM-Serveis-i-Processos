import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class pF {
    public static void main(String[] args) {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            String palabra = entrada.readLine();

            ProcessBuilder pb = new ProcessBuilder("java", "pG.java");
            pb.redirectErrorStream(true);
            Process proceso = pb.start();

            BufferedWriter escrito = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            escrito.write(palabra);
            escrito.newLine();
            escrito.flush();
            escrito.close();

            BufferedReader lee = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String estaLinea;
            while ((estaLinea = lee.readLine()) != null) {
                System.out.println("pF enseña: " + estaLinea);
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
