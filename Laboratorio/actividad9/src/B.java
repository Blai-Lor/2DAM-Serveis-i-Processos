import java.io.IOException;

public class B {
    public static void main(String[] args) {
        try {
            ProcessBuilder pbA = new ProcessBuilder("java", "A.java");
            pbA.inheritIO();
            Process procesA = pbA.start();
            long pidA = procesA.pid();
            System.out.println("B ha creado A con PID " + pidA);

            Thread.sleep(3000);

            System.out.println("B ha enviado ALRM");
            new ProcessBuilder("kill", "-ALRM", String.valueOf(pidA)).start().waitFor();

            Thread.sleep(2000);

            System.out.println("B ha enviado HUP");
            new ProcessBuilder("kill", "-HUP", String.valueOf(pidA)).start().waitFor();

            procesA.waitFor();
            System.out.println("B dice que A ha acabado.");

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso hijo ha tenido un error.");
            System.exit(-1);
        }
    }
}

