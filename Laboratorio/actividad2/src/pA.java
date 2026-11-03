import java.io.IOException;

public class pA {
    public static void main(String[] args) {
        try {
            long pidPare = ProcessHandle.current().pid();
            System.out.println("PID Padre: " + pidPare);

            ProcessBuilder pb = new ProcessBuilder("java", "p2.java");
            pb.inheritIO();
            Process proceso = pb.start();
            proceso.waitFor();
            System.out.println("El proceso del fill ha acabado.");

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso hijo ha tenido un error.");
            System.exit(-1);
        }
    }
}