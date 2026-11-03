import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pB {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "p2.java");
            pb.redirectErrorStream(true);

            Process proceso = pb.start();
            BufferedReader lee = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String estaLinea;
            while ((estaLinea = lee.readLine()) != null) {
                System.out.println("Salida del hioj: " + estaLinea);
            }

            proceso.waitFor();
            System.out.println("El proceso del hijo ha acabado.");

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso hijo ha tenido un error.");
            System.exit(-1);
        }
    }
}