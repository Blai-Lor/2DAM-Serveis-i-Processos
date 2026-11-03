import java.io.IOException;
import sun.misc.Signal;

class Final {
    public static void main(String[] args) {
        try {
            long pidFinal = ProcessHandle.current().pid();
            System.out.println("final: mi PID es " + pidFinal);

            Signal.handle(new Signal("INT"), signal -> {
                System.out.println("final: he recibido SIGINT, me han interrumpido.");
                System.exit(0);
            });

            ProcessBuilder pb = new ProcessBuilder("java", "final2.java", String.valueOf(pidFinal));
            pb.inheritIO();
            Process proceso = pb.start();

            proceso.waitFor();
            Thread.sleep(5000);
            System.out.println("final: no he recibido SIGINT.");

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso hijo ha tenido un error.");
            System.exit(-1);
        }
    }
}
