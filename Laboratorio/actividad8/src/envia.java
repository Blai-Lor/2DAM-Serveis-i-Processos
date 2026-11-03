import java.io.IOException;
import java.util.Scanner;

public class envia {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("PID del proceso:");
            String pid = sc.nextLine();
            System.out.println("Señal (TERM, HUP, INT):");
            String señal = sc.nextLine();

            ProcessBuilder pb = new ProcessBuilder("kill", "-" + señal, pid);
            pb.inheritIO();
            Process proceso = pb.start();
            proceso.waitFor();
            System.out.println("Señal " + señal + " enviada al PID " + pid);

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso ha tenido un error.");
            System.exit(-1);
        }
    }
}
